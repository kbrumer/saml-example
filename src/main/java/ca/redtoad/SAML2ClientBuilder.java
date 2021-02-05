package ca.redtoad;

import org.opensaml.saml.common.xml.SAMLConstants;
import org.pac4j.saml.client.SAML2Client;
import org.pac4j.saml.config.SAML2Configuration;

public class SAML2ClientBuilder {

    public SAML2Client build() {
        SAML2Configuration config = new SAML2Configuration();
        config.setIdentityProviderMetadataResourceUrl(getClass().getResource("/idp-metadata.xml").toString());
        config.setSpLogoutRequestBindingType(SAMLConstants.SAML2_REDIRECT_BINDING_URI);

        config.setKeystorePath("resource:samlKeystore.jks");
        config.setKeystorePassword("pac4j-demo-passwd");
        config.setPrivateKeyPassword("pac4j-demo-passwd");
        config.setKeystoreAlias("pac4j-demo");

        SAML2Client saml2Client = new SAML2Client(config);
        saml2Client.setName("SAMLExample");
        saml2Client.setCallbackUrl("http://localhost:8080/login/finish");
        saml2Client.init();

        return saml2Client;
    }
}
