# Number Grid — Android Homework 1

A small Android application built with **Kotlin** and **Jetpack Compose** for Homework #1 — *Working with Lists*.

The project demonstrates responsive grid layouts, state preservation across configuration changes, resource usage, and basic interaction with Compose.

## Features

- Displays square items in a scrollable grid
- Uses **3 columns in portrait orientation**
- Uses **4 columns in landscape orientation**
- Uses a **1-based index** for generated items
- Colors items based on index parity:
  - even indices — red
  - odd indices — blue
- Adds new items with a button in the bottom-right corner
- Keeps enough bottom padding so the add button does not cover the last grid items
- Preserves the number of items after screen rotation with `rememberSaveable`
- Keeps every grid item square using a `1:1` aspect ratio
- Shows the item's index in a `Toast` when the item is tapped
- Does not use persistent storage
- Does not request Internet access
- Uses Android resources for UI dimensions, colors, and strings
- Contains no `Log.*` calls

## Tech Stack

- Kotlin
- Jetpack Compose
- Material 3
- AndroidX Activity Compose
- Compose `LazyVerticalGrid`
- `rememberSaveable`

## How It Works

The screen consists of two main parts:

1. A scrollable grid of square items
2. An add button positioned in the bottom-right corner

The number of columns depends on the current device orientation:

```text
Portrait   -> 3 columns
Landscape  -> 4 columns
```

Each new item receives the next index in the list.

Odd indices use a blue background, while even indices use a red background.

The item count is stored with `rememberSaveable`, so rotating the device does not reset the list.

## State Preservation

The application does not use files, `SharedPreferences`, or any other persistent storage.

Instead, the current item count is stored in Compose state:

```kotlin
var count by rememberSaveable {
    mutableStateOf(Constants.START_COUNT_SQUARES)
}
```

This keeps the value across configuration changes such as screen rotation while following the homework restriction against persistent storage.

## Responsive Grid

The grid is implemented with `LazyVerticalGrid`.

The number of columns is selected according to the current orientation:

```kotlin
val countColumn =
    if (LocalConfiguration.current.orientation == ORIENTATION_PORTRAIT)
        Constants.PORTRAIT_COLUMNS
    else
        Constants.LANDSCAPE_COLUMNS
```

The project defines:

```text
Portrait  -> 3 columns
Landscape -> 4 columns
```

## Square Items

Each grid element uses:

```kotlin
Modifier.aspectRatio(Constants.ASPECT_RATIO_SQUARE)
```

with an aspect ratio of `1f`, so every item remains square regardless of screen size.

Items are colored according to their index:

```text
Odd index  -> blue
Even index -> red
```

Tapping an item displays its index in a short Android `Toast`.

## Add Button

The add button is placed in the bottom-right corner of the screen.

Pressing it increments the item count and adds a new square to the grid.

The grid includes additional bottom content padding based on the button size and spacing, preventing the button from covering the last items when the list is scrolled to the end.

## Project Structure

```text
app/src/main/
├── AndroidManifest.xml
│
├── java/com/example/myapplication/
│   ├── Constants.kt
│   ├── MainActivity.kt
│   │
│   ├── components/
│   │   ├── AddButton.kt
│   │   ├── ButtonWrap.kt
│   │   ├── Square.kt
│   │   └── Squares.kt
│   │
│   ├── screen/
│   │   └── MyScreen.kt
│   │
│   └── ui/theme/
│       ├── Color.kt
│       ├── Theme.kt
│       └── Type.kt
│
└── res/
    ├── drawable/
    ├── mipmap-*/
    ├── values/
    │   ├── colors.xml
    │   ├── constants.xml
    │   ├── strings.xml
    │   └── themes.xml
    └── xml/
```

## Main Components

### `MainActivity`

The application's entry point. It initializes the Compose UI and displays `MyScreen`.

### `MyScreen`

Stores the current number of items with `rememberSaveable` and combines the grid with the add button.

### `Squares`

Creates the responsive `LazyVerticalGrid`, chooses the number of columns based on orientation, and provides bottom padding for the add button.

### `Square`

Represents one square grid item. It selects the background color from the item's index parity and shows the index in a `Toast` when tapped.

### `AddButton`

Adds a new item to the list.

### `ButtonWrap`

Positions the add button at the bottom-right of the screen.

### `Constants`

Contains application-level values such as the portrait and landscape column counts and aspect ratios.

## Homework Requirements

The project was created for Homework #1 — **Working with Lists**.

The assignment focuses on:

- displaying items in a multi-column grid;
- using 3 columns in portrait mode and 4 columns in landscape mode;
- using different colors for even and odd items;
- adding new items with a button;
- preventing the button from covering the end of the list;
- preserving the item count after screen rotation;
- avoiding persistent storage;
- avoiding Internet access;
- avoiding hardcoded UI resources;
- removing logging from the final version.

The project also implements the optional square-item layout.

## Requirements

- Android Studio
- Android SDK
- JDK 11 or newer
- Minimum Android SDK: 24

## Getting Started

### 1. Clone the repository

```bash
git clone <repository-url>
cd homework1_android_vk
```

### 2. Open the project

Open the project directory in Android Studio and wait for Gradle synchronization to finish.

### 3. Run the application

Select an Android emulator or a physical Android device and run the `app` configuration.

You can also build the debug APK from the command line:

```bash
./gradlew assembleDebug
```

On Windows:

```bash
gradlew.bat assembleDebug
```

## Build Configuration

```text
Minimum SDK: 24
Target SDK: 36
Compile SDK: 36
Java: 11
```

## Author

**Varvara Berezetskaia**
