# Installing Keycloak
```bash
cd /usr/local
sudo mv ~/Downloads/keycloak-12.0.2.zip .
sudo unzip keycloak-12.0.2.zip
sudo ln -s keycloak-12.0.2 keycloak
sudo chown -R `whoami`:staff keycloak-12.0.2
sudo rm keycloak-12.0.2.zip
cd keycloak
# avoid running on port 8080
./bin/standalone.sh -Djboss.socket.binding.port-offset=100

# new tab
open http://localhost:8180
```

## Add Admin User
Add Admin User
U/P: admin/62M35iG8tZ#XUxg

Login into the Admin console with this user

## Import Keycloak realm
You must import new realm 'saml-demo': upload 'docs/saml-demo.json' to
form: http://localhost:8180/auth/admin/master/console/#/create/realm

Also, for client with name 'http://localhost:8080/login?client_name=SAML2Client'
of realm with name 'saml-demo' you must import keys from 'src/main/resources/samlKeystore.jks':
```
http://localhost:8180/auth/admin/master/console/#/realms/saml-demo/clients
   -> Choose Client ID 'http://localhost:8080/login?client_name=SAML2Client' 
   -> SAML Keys.
```

### Signing Key import
```
Archive Format: JKS
Key Alias: pac4j-demo
Store Password: pac4j-demo-passwd
Import File: 'src/main/resources/samlKeystore.jks'
```

### Encryption Key import
```
Archive Format: JKS
Key Alias: pac4j-demo
Store Password: pac4j-demo-passwd
Import File: 'src/main/resources/samlKeystore.jks'
```

# Application Start
```bash
mvn clean install
java -jar target/saml-example-1.0.0.jar
```

or by running the Main class file in your preferred IDE

# Login
```bash
# new tab
open http://localhost:8080  # > Click secure link
# Get redirected to keycloak
# login with U/P: bburke/password
```
