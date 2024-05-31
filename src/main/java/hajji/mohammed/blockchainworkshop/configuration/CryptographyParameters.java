package hajji.mohammed.blockchainworkshop.configuration;


import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "security.params")
@Getter @Setter
public class CryptographyParameters {
    private  String signatureAlgorithme;
    private  String ecGenParameterSpec;
}
