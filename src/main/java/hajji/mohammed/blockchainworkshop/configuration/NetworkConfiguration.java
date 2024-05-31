package hajji.mohammed.blockchainworkshop.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "blockchain.network")
@Getter @Setter
public class NetworkConfiguration {
    private int minderNode = 2;
    private int fullNode = 2;
    private int svpNode = 2;
}
