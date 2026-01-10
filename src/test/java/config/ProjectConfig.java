package config;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.ConfigFactory;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "system:env",
        "classpath:${platform}.properties",
        "classpath:android.properties"
})
public interface ProjectConfig extends Config {

    ProjectConfig projectConfig = ConfigFactory.create(ProjectConfig.class);

    @Key("userName")
    String browserstackUser();

    @Key("accessKey")
    String browserstackKey();

    @Key("browserstackApp")
    String browserstackApp();

    @Key("browserstackUrl")
    String browserstackUrl();

    @Key("platformVersion")
    String platformVersion();

    @Key("deviceName")
    String deviceName();

    @Key("timeout")
    long timeout();

    @Key("appiumUrl")
    String appiumUrl();

    @Key("app")
    String app();

    @Key("appPackage")
    String appPackage();

    @Key("appActivity")
    String appActivity();
}
