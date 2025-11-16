package drivers;

import com.codeborne.selenide.WebDriverProvider;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import org.jspecify.annotations.NonNull;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import static config.ProjectConfig.projectConfig;

public class BrowserStackDriver implements WebDriverProvider {

    @NonNull
    @Override
    public WebDriver createDriver(@NonNull Capabilities capabilities) {
        String platform = System.getProperty("platform", "android");
        return switch (platform) {
            case "bs-android" -> bsAndroidDriver();
            case "bs-ios" -> bsIOSDriver();
            case "real-device", "emulator" -> localAndroidDriver();
            default -> null;
        };
    }

    private WebDriver bsAndroidDriver() {
        UiAutomator2Options options = new UiAutomator2Options()
                .setApp(projectConfig.browserstackApp())
                .setDeviceName(projectConfig.deviceName())
                .setPlatformVersion(projectConfig.platformVersion());
//        options.setCapability("appium:app", projectConfig.browserstackApp());
//        options.setCapability("appium:deviceName", projectConfig.deviceName());
//        options.setCapability("appium:platformVersion", projectConfig.platformVersion());

        return new AndroidDriver(getServerUrl(), options);
    }

    private WebDriver bsIOSDriver() {
        XCUITestOptions options = new XCUITestOptions()
                .setApp(projectConfig.browserstackApp())
                .setDeviceName(projectConfig.deviceName())
                .setPlatformVersion(projectConfig.platformVersion());
//        options.setCapability("appium:app", projectConfig.browserstackApp());
//        options.setCapability("appium:deviceName", projectConfig.deviceName());
//        options.setCapability("appium:platformVersion", projectConfig.platformVersion());

        return new IOSDriver(getServerUrl(), options);
    }

    private WebDriver localAndroidDriver() {
        UiAutomator2Options options = new UiAutomator2Options()
                .setPlatformName("")
                .setPlatformVersion("")
                .setAutomationName("")
                .setApp("")
                .setAppPackage("")
                .setAppActivity("");

//        options.setCapability("appium:app", projectConfig.browserstackApp());
//        options.setCapability("appium:deviceName", projectConfig.deviceName());
//        options.setCapability("appium:platformVersion", projectConfig.platformVersion());

        return new AndroidDriver(getServerUrl(), options);
    }

    private URL getServerUrl() {
        String platform = System.getProperty("platform", "android");
        try {
            if (platform.equals("bs-android") || platform.equals("bs-ios")) {
                return new URL(String.format(
                        projectConfig.browserstackUrl(),
                        projectConfig.browserstackUser(),
                        projectConfig.browserstackKey()
                ));
            } else if (platform.equals("real-device") || platform.equals("emulator")) {
                return new URI(projectConfig.appiumUrl()).toURL();
            } else {
                throw new RuntimeException("Передано неверное название платформы");
            }
        } catch (MalformedURLException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

}
