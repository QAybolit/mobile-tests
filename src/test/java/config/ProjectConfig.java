package config;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.ConfigFactory;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "system:env",
        "classpath:${platform}.properties",
        "classpath:bs-android.properties"
})
public interface ProjectConfig extends Config {

    ProjectConfig projectConfig = ConfigFactory.create(ProjectConfig.class);

    @Key("userName")
    String browserstackUser();

    @Key("accessKey")
    String browserstackKey();

    @Key("browserstack.app")
    String browserstackApp();

    @Key("browserstack.url")
    String browserstackUrl();

    @Key("platform.name")
    String platformName();

    @Key("platform.version")
    String platformVersion();

    @Key("device.name")
    String deviceName();

    @Key("timeout")
    long timeout();

    @Key("automation.name")
    String automationName();

    @Key("appium.url")
    String appiumUrl();

    @Key("app")
    String app();

    @Key("app.package")
    String appPackage();

    @Key("app.activity")
    String appActivity();

    @Key("project.name")
    String projectName();

    @Key("build.name")
    String buildName();

    @Key("name")
    String name();
}
