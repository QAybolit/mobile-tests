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
import java.net.URL;

import static config.ProjectConfig.projectConfig;

public class BrowserStackDriver implements WebDriverProvider {

    @NonNull
    @Override
    public WebDriver createDriver(@NonNull Capabilities capabilities) {
        String platform = System.getProperty("platform", "android");
        if (platform.equals("android")) {
            return androidDriver();
        } else if (platform.equals("ios")) {
            return IOSDriver();
        } else {
            return null;
        }
    }

    private WebDriver androidDriver() {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setCapability("appium:app", projectConfig.browserstackApp());
        options.setCapability("appium:deviceName", projectConfig.deviceName());
        options.setCapability("appium:platformVersion", projectConfig.platformVersion());

        return new AndroidDriver(getServerUrl(), options);
    }

    private WebDriver IOSDriver() {
        XCUITestOptions options = new XCUITestOptions();
        options.setCapability("appium:app", projectConfig.browserstackApp());
        options.setCapability("appium:deviceName", projectConfig.deviceName());
        options.setCapability("appium:platformVersion", projectConfig.platformVersion());

        return new IOSDriver(getServerUrl(), options);
    }

    private URL getServerUrl() {
        try {
            return new URL(String.format(projectConfig.browserstackUrl(), projectConfig.browserstackUser(), projectConfig.browserstackKey()));
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

}
