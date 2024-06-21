plugins {
    alias(libs.plugins.androidLibrary)
    id("maven-publish")
}

android {
    namespace = "com.example.mylibrary"
    compileSdk = 34

    defaultConfig {
        minSdk = 34

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}

group = "com.github.jitpack"
version = "1.0"

publishing {
    publications {
        create<MavenPublication>("jitpack") {
            //from(components["release"])

            groupId = "com.github.lalitavcp" // Replace with your GitHub username or organization
            artifactId = "TestSimpleLibraryApp"    // Replace with your repository name

            version = "1.0" // Replace with your desired version

            pom {
                name.set("TestSimpleLibraryApp")
                description.set("A description of your library.")
                url.set("https://github.com/lalitavcp/TestSimpleLibraryApp")

               /* licenses {
                    license {
                        name.set("The Apache License, Version 2.0")
                        url.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
                    }
                }*/

               /* developers {
                    developer {
                        id.set("developerId")
                        name.set("Your Name")
                        email.set("your-email@example.com")
                    }
                }
*/
                scm {
                    url.set("https://github.com/lalitavcp/TestSimpleLibraryApp")
                    connection.set("scm:git:https://github.com/lalitavcp/TestSimpleLibraryApp.git")
                    developerConnection.set("scm:git:ssh://github.com/lalitavcp/TestSimpleLibraryApp.git")
                }
            }
        }
    }

    repositories {
        maven {
            // JitPack repository URL
            url = uri("https://jitpack.io")
        }
    }
}
