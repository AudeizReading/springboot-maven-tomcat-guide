# README - Configuration et Déploiement de Spring Boot avec Tomcat

Ce fichier explique comment configurer et exécuter un projet Spring Boot avec Tomcat en mode embedded (pour le développement) ou sur un serveur externe (pour le déploiement). Vous trouverez également les instructions pour installer et configurer les outils nécessaires (Maven, JDK/JRE, Spring Boot, et Spring Tool Suite).

---

## 1. **Prérequis**

### **A. Outils requis**

1. **JDK 17 ou 23**
   - Requis pour compiler et exécuter des applications Java.
2. **Apache Maven**
   - Utilisé pour la gestion des dépendances et la construction du projet.
3. **Spring Boot**
   - Framework pour construire des applications Java.
4. **Spring Tool Suite (STS)**
   - IDE basé sur Eclipse, optimisé pour le développement Spring Boot.
5. **Tomcat** (optionnel, pour déploiement externe uniquement).

---

## 2. **Installation des outils**

### **A. Installation sur macOS**

#### 1. Installer le JDK 17 ou 23

- Téléchargez le JDK depuis [Oracle JDK](https://www.oracle.com/java/technologies/javase-downloads.html) ou [AdoptOpenJDK](https://adoptium.net/).
- Installez-le via le fichier `.dmg`.
- Vérifiez l'installation :

```bash
  java -version
```

##### Documentation

- [Installation](https://docs.oracle.com/en/java/javase/23/install/installation-jdk-macos.html#GUID-2FE451B0-9572-4E38-A1A5-568B77B146DE)

#### 2. Installer Maven

- Téléchargez Maven depuis [Apache Maven](https://maven.apache.org/download.cgi).
- [Décompressez](https://maven.apache.org/install.html) l'archive dans `/usr/local/apache-maven`.

```bash
sudo unzip apache-maven-3.9.9-bin.zip -d /usr/local/apache-maven/
# ou
tar xzvf apache-maven-3.9.9-bin.tar.gz # Les versions tar ont du mal sur Mac
```

- [Vérifier](https://www.apache.org/info/verification.html) les shasum relatives aux fichiers d'installation

- Ajoutez Maven au `PATH` dans le fichier `~/.zshrc` :

```bash
  export M2_HOME=/usr/local/apache-maven/apache-maven-<version>
  export PATH=$PATH:$M2_HOME/bin
```

- Vérifiez l'installation :

```bash
mvn -v
```

##### Documentation

- [Getting Started](https://maven.apache.org/guides/getting-started/index.html)
- [Guide Configuration](https://maven.apache.org/guides/mini/guide-configuring-maven.html)
- [Guide Mirrors](https://maven.apache.org/guides/mini/guide-mirror-settings.html)
- [Guide Proxy](https://maven.apache.org/guides/mini/guide-proxies.html)
- [Guide Password Encryption](https://maven.apache.org/guides/mini/guide-encryption.html)

Regardez du coté de ces fichiers de configurations si soucis par la suite:

- [Guide Settings](https://maven.apache.org/settings.html)
  - `/usr/local/apache-maven/apache-maven-3.9.9/conf/settings.xml`
  - `/${HOME}/.m2/settings.xml`

#### 3. Installer Spring Tool Suite (STS)

- Téléchargez STS depuis [Spring.io](https://spring.io/tools).
- Déplacez l’application dans le dossier `Applications`.

Ou installez le plugin de votre IDE préféré:

- Eclipse:
  - [Windows](https://cdn.spring.io/spring-tools/release/STS4/4.27.0.RELEASE/dist/e4.34/spring-tool-suite-4-4.27.0.RELEASE-e4.34.0-win32.win32.x86_64.zip)
  - [MacOSX](https://cdn.spring.io/spring-tools/release/STS4/4.27.0.RELEASE/dist/e4.34/spring-tool-suite-4-4.27.0.RELEASE-e4.34.0-macosx.cocoa.aarch64.dmg)
- [VSCode](https://marketplace.visualstudio.com/items?itemName=vmware.vscode-boot-dev-pack)

##### Documentation

[Spring Boot](https://spring.io/projects/spring-boot) .  
[Quick Start](https://spring.io/quickstart) .

#### 4. Installer Tomcat

- Téléchargez Tomcat depuis [Tomcat Apache](https://tomcat.apache.org/).
- Décompressez dans `/usr/local/tomcat`. (L'archive .tar ne fonctionne pas sur MacOSX d'après le site)

```bash
sudo unzip ~/Downloads/apache-tomcat-11.0.2.zip -d /usr/local/tomcat/
```

- Configurez le `PATH` :

```bash
  export CATALINA_HOME=/usr/local/tomcat/apache-tomcat-<version>
  export PATH=$PATH:$CATALINA_HOME/bin
```

- Lancez Tomcat :

```bash
sudo chmod +x /usr/local/tomcat/apache-tomcat-11.0.2/bin/catalina.sh
sudo catalina.sh start
```

##### Documentation

- [Tomcat 11](https://tomcat.apache.org/tomcat-11.0-doc/index.html)

### **B. Installation sur Windows 11**

#### 1. Installer le JDK 17 ou 23

- Téléchargez et installez le JDK depuis [Oracle JDK](https://www.oracle.com/java/technologies/javase-downloads.html).
- Ajoutez `JAVA_HOME` aux variables d’environnement :
  - Allez dans **Paramètres système avancés** > **Variables d’environnement**.
  - Ajoutez une nouvelle variable utilisateur :

```txt
    Nom : JAVA_HOME
    Valeur : C:\Program Files\Java\jdk-<version>
```

- Vérifiez :

```cmd
java -version
```

#### 2. Installer Maven

- Téléchargez Maven depuis [Apache Maven](https://maven.apache.org/download.cgi).
- Décompressez dans `C:\Program Files\Apache-Maven`.
- Ajoutez `M2_HOME` au **Path** des variables système.
- Vérifiez :

```cmd
mvn -v
```

##### Documentation

- [Getting Started](https://maven.apache.org/guides/getting-started/index.html)
- [Guide Configuration](https://maven.apache.org/guides/mini/guide-configuring-maven.html)
- [Guide Mirrors](https://maven.apache.org/guides/mini/guide-mirror-settings.html)
- [Guide Proxy](https://maven.apache.org/guides/mini/guide-proxies.html)
- [Guide Password Encryption](https://maven.apache.org/guides/mini/guide-encryption.html)

Regardez du coté de ces fichiers de configurations si soucis par la suite:

- [Guide Settings](https://maven.apache.org/settings.html)
  - `C:\%M2_HOME%conf\settings.xml`
  - `C:\%USER%\.m2\settings.xml`

#### 3. Installer Spring Tool Suite (STS)

- Téléchargez STS depuis [Spring.io](https://spring.io/tools).
- Installez et configurez selon les instructions du programme d’installation.

Ou installez le plugin de votre IDE préféré:

- Eclipse:
  - [Windows](https://cdn.spring.io/spring-tools/release/STS4/4.27.0.RELEASE/dist/e4.34/spring-tool-suite-4-4.27.0.RELEASE-e4.34.0-win32.win32.x86_64.zip)
  - [MacOSX](https://cdn.spring.io/spring-tools/release/STS4/4.27.0.RELEASE/dist/e4.34/spring-tool-suite-4-4.27.0.RELEASE-e4.34.0-macosx.cocoa.aarch64.dmg)
- [VSCode](https://marketplace.visualstudio.com/items?itemName=vmware.vscode-boot-dev-pack)

##### Documentation

[Spring Boot](https://spring.io/projects/spring-boot) .  
[Quick Start](https://spring.io/quickstart) .

#### 4. Installer Tomcat

- Téléchargez et décompressez Tomcat dans `C:\Tomcat`.
- Lancez le serveur avec `startup.bat` dans `C:\Tomcat\bin`.

---

## 3. **Créer et configurer un projet Spring Boot avec Maven**

### **A. Installation de Spring Boot**

1. **Installer Spring Boot CLI** (Optionnel) :

   - Téléchargez Spring Boot CLI depuis [Spring Boot CLI](https://spring.io/tools).
   - Ajoutez le chemin d’accès à `spring` dans votre `PATH`.

2. **Vérifier l’installation** :

```bash
  spring --version
```

### **B. Créer un projet Spring Boot avec Maven**

1. **Générer un projet avec Spring Initializr** :

   - Rendez-vous sur [Spring Initializr](https://start.spring.io/).
   - Configurez le projet :
     - **Type de projet** : Maven
     - **Langage** : Java
     - **Packager** : Jar (ou War pour une utilisation avec un Tomcat externe)
     - **Dépendances** : Spring Web, Spring Boot DevTools (optionnel).
   - Téléchargez l’archive ZIP générée.

2. **Importer le projet dans un IDE** :
   - Décompressez l’archive dans un répertoire local.
   - Importez le projet dans votre IDE (IntelliJ, STS, ou Eclipse).

#### Documentation

- [Building an Application with Spring Boot](https://spring.io/guides/gs/spring-boot)
- [Spring Boot Guides](https://spring.io/guides)
- [Api Rest Oauth2 / Angular](https://www.baeldung.com/rest-api-spring-oauth2-angular)

### **C. Configuration pour le mode développement avec Tomcat embedded**

1. **Ajouter les dépendances nécessaires dans [`pom.xml`](https://maven.apache.org/guides/introduction/introduction-to-the-pom.html)** :

   ```xml
   <dependencies>
       <dependency>
           <groupId>org.springframework.boot</groupId>
           <artifactId>spring-boot-starter-web</artifactId>
       </dependency>
   </dependencies>
   ```

2. **Configurer les propriétés du serveur dans `src/main/resources/application.properties`** :

```properties
server.port=8080
server.address=127.0.0.1
```

- `server.port` : Définit le port d’écoute (par défaut 8080).
- `server.address` : Permet d’écouter sur une adresse localisée.

3. **Exécuter l’application avec Maven** :

```bash
   mvn spring-boot:run
```

### **D. Configuration pour la production avec un serveur Tomcat externe**

1. **Changer le type de packaging**

   - Modifiez le [`pom.xml`](https://maven.apache.org/guides/introduction/introduction-to-the-pom.html) pour utiliser le type `war` :

```xml
<packaging>war</packaging>
```

2. **Étendre la classe principale**

   - Modifiez la classe principale de l’application pour étendre `SpringBootServletInitializer` :

```java
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class Application extends SpringBootServletInitializer {
 @Override
 protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
  return application.sources(Application.class);
 }

 public static void main(String[] args) {
  SpringApplication.run(Application.class, args);
 }
}
```

3. **Déployer sur Tomcat**

   - Compilez et empaquetez votre application :

```bash
mvn clean package
```

- Copiez le fichier `.war` dans le répertoire `webapps` de Tomcat :

```bash
cp target/mon-application.war /usr/local/tomcat/webapps/
```

- Redémarrez Tomcat pour déployer l’application.

---

## 4. **Configuration du serveur intégré Tomcat**

### **A. Dépendance Maven**

Si vous l'avez déjà fait, sautez cette étape.
Vérifiez que votre projet inclut la dépendance suivante dans le fichier [`pom.xml`](https://maven.apache.org/guides/introduction/introduction-to-the-pom.html) :

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>
```

#### **Ajouter le plugin Tomcat à Maven**

Si vous l'avez déjà fait, sautez cette étape.

1. Ajoutez le plugin [Tomcat](<(https://tomcat.apache.org/maven-plugin.html)>) dans le fichier [`pom.xml`](https://maven.apache.org/guides/introduction/introduction-to-the-pom.html) :

   ```xml
   <build>
       <plugins>
           <plugin>
               <groupId>org.apache.tomcat.maven</groupId>
               <artifactId>tomcat7-maven-plugin</artifactId>
               <version>2.2</version>
           </plugin>
       </plugins>
   </build>
   ```

2. Déployez sur Tomcat avec la commande suivante :

```sh
mvn tomcat7:run
```

### **B. Configuration du serveur**

Ajoutez ou modifiez les paramètres dans `application.properties` :

```properties
server.port=8080
server.address=0.0.0.0
```

- `server.port` : Définit le port d’écoute (par défaut 8080).
- `server.address` : Permet d’écouter sur toutes les interfaces réseau.

### **C. Démarrer l’application**

Compilez et exécutez votre application :

```bash
mvn clean install
java -jar target/ton-application.jar
```

---

## 4. **Déployer avec un serveur Tomcat externe**

### **A. Changer le packaging**

Dans [`pom.xml`](https://maven.apache.org/guides/introduction/introduction-to-the-pom.html), changez le type de packaging à `war` :

```xml
<packaging>war</packaging>
```

### **B. Étendre `SpringBootServletInitializer`**

Modifiez votre classe principale pour qu’elle étende `SpringBootServletInitializer` :

```java
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class Application extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
```

### **C. Déployer le fichier .war**

1. Compilez votre projet :

```bash
   mvn clean package
```

2. Copiez le fichier `.war` généré dans le répertoire `webapps` de Tomcat.
3. Redémarrez Tomcat pour déployer l’application.

---

## 5. **Tester l’accès à votre application**

- **Serveur intégré** :

```txt
  http://localhost:8080
```

- **Serveur externe (Tomcat)** :

```txt
  http://<adresse-ip>:8080/<nom-de-l-application>
```

---

Ceci est la facon simple de faire tourner une web app Spring Boot sur un serveur Tomcat.
Prochaine étpae configuration derrière un proxy et validation de la procédure pour Windows 11.
