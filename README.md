# ChatBot SDK

Android ChatBot SDK built using Kotlin and Jetpack Compose.

---

# Features

- Support chatbot flow
- Dynamic option selection
- Jetpack Compose UI
- Easy integration
- Customizable chatbot

---

# Installation

## Step 1: Add JitPack

Add in `settings.gradle`

```gradle
dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
        maven { url = uri("https://jitpack.io") }
    }
}
```

## Step 2: Add Dependency

```gradle
implementation("com.github.nitin09542:chatLibrary:2.0.0")
```

---

# Usage

## Initialize SDK

```kotlin
ChatBotSDK.initialize(
    context = this
)
```

## Open ChatBot

```kotlin
ChatBotScreen()
```

---

# Customization

You can customize:
- Theme
- Colors
- Chat options
- Support flow

---

# Version

Current Version:
```text
2.0.0
```

---

# Author

Nitin Kumar
