package drivers;

import com.codeborne.selenide.WebDriverProvider;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import org.apache.commons.io.FileUtils;
import org.jspecify.annotations.NonNull;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import static config.ProjectConfig.projectConfig;
import static io.appium.java_client.remote.AutomationName.ANDROID_UIAUTOMATOR2;
import static io.appium.java_client.remote.MobilePlatform.ANDROID;

public class ProjectDriver implements WebDriverProvider {

    @NonNull
    @Override
    public WebDriver createDriver(@NonNull Capabilities capabilities) {
        String platform = System.getProperty("platform", "bs-android");
        return switch (platform) {
            case "bs-android" -> bsAndroidDriver();
            case "bs-ios" -> bsIOSDriver();
            case "real-device", "emulator" -> localAndroidDriver();
            default -> throw new AssertionError("Передано некорректное название платформы: [" + platform + "]");
        };
    }

    private WebDriver bsAndroidDriver() {
        UiAutomator2Options options = new UiAutomator2Options()
                .setApp(projectConfig.browserstackApp())
                .setDeviceName(projectConfig.deviceName())
                .setPlatformVersion(projectConfig.platformVersion());

        return new AndroidDriver(getServerUrl(), options);
    }

    private WebDriver bsIOSDriver() {
        XCUITestOptions options = new XCUITestOptions()
                .setApp(projectConfig.browserstackApp())
                .setDeviceName(projectConfig.deviceName())
                .setPlatformVersion(projectConfig.platformVersion());

        return new IOSDriver(getServerUrl(), options);
    }

    private WebDriver localAndroidDriver() {
        UiAutomator2Options options = new UiAutomator2Options()
                .setPlatformName(ANDROID)
                .setPlatformVersion(projectConfig.platformVersion())
                .setAutomationName(ANDROID_UIAUTOMATOR2)
                .setDeviceName(projectConfig.deviceName())
                .setApp(getAppPath())
                .setAppPackage(projectConfig.appPackage())
                .setAppActivity(projectConfig.appActivity());

        return new AndroidDriver(getServerUrl(), options);
    }

    private URL getServerUrl() {
        String platform = System.getProperty("platform", "bs-android");
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

    private String getAppPath() {
        String appUrl = "https://github.com/wikimedia/apps-android-wikipedia/releases/download/latest/" + projectConfig.app();
        String appPath = "src/test/resources/apps/" + projectConfig.app();

        File app = new File(appPath);
        if (!app.exists()) {
            try (InputStream in = new URL(appUrl).openStream()) {
                FileUtils.copyInputStreamToFile(in, app);
            } catch (IOException e) {
                throw new AssertionError("Не удалось скачать приложение", e);
            }
        }
        return app.getAbsolutePath();
    }

}
