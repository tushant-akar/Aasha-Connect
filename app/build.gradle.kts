plugins {
    id("com.android.application")
    id("com.google.gms.google-services")
}

android {
    namespace = "com.hackhurricane.aashaconnect"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.hackhurricane.aashaconnect"
        minSdk = 29
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
    buildFeatures {
        viewBinding = true
    }
    packaging {
        resources.excludes.add("META-INF/DEPENDENCIES")
    }
}

dependencies {

    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.navigation:navigation-fragment:2.7.6")
    implementation("androidx.annotation:annotation:1.7.1")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.6.2")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.2")
    implementation("com.pierfrancescosoffritti.androidyoutubeplayer:core:12.1.0")
    implementation("org.apache.poi:poi:5.0.0")
    implementation("org.apache.poi:poi-ooxml:5.0.0") {
        exclude(group = "org.apache.xmlgraphics", module = "batik-all")
        exclude(group = "org.apache.xmlgraphics", module = "batik-util")
        exclude(group = "org.apache.xmlgraphics", module = "batik-anim")
        exclude(group = "org.apache.xmlgraphics", module = "batik-svgrasterizer")
        exclude(group = "org.apache.xmlgraphics", module = "batik-slideshow")
        exclude(group = "org.apache.xmlgraphics", module = "batik-svgbrowser")
        exclude(group = "org.apache.xmlgraphics", module = "batik-bridge")
        exclude(group = "org.apache.xmlgraphics", module = "batik-css")
        exclude(group = "org.apache.xmlgraphics", module = "batik-dom")
        exclude(group = "org.apache.xmlgraphics", module = "batik-svg-dom")
        exclude(group = "org.apache.xmlgraphics", module = "batik-awt-util")
        exclude(group = "org.apache.xmlgraphics", module = "batik-codec")
        exclude(group = "org.apache.xmlgraphics", module = "batik-gvt")
        exclude(group = "org.apache.xmlbeans", module = "xmlbeans")
        exclude(group = "org.apache.xmlgraphics", module = "batik-parser")
        exclude(group = "org.apache.xmlgraphics", module = "batik-script")
        exclude(group = "org.apache.xmlgraphics", module = "batik-svggen")
        exclude(group = "org.apache.xmlgraphics", module = "batik-transcoder")
        exclude(group = "org.apache.xmlgraphics", module = "batik-extension")
        exclude(group = "org.apache.xmlgraphics", module = "batik-extension-svg")
        exclude(group = "org.apache.xmlgraphics", module = "batik-extension-xml")
        exclude(group = "org.apache.xmlgraphics", module = "batik-rasterizer")
        exclude(group = "org.apache.xmlgraphics", module = "batik-util")
        exclude(group = "org.apache.xmlgraphics", module = "batik-xml")
        exclude(group = "org.apache.xmlgraphics", module = "batik-xml-apis")
    }
    implementation("com.google.firebase:firebase-auth:22.3.0")
    implementation("com.google.firebase:firebase-database:20.3.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}