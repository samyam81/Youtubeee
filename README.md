# Video List App

This Android application displays a list of videos using a RecyclerView. Each item in the list represents a video with its title.

## Features

- Displays a list of videos fetched from a data source.
- Clicking on a video item displays a toast with the video title.

## Requirements

- Android Studio
- Android SDK

## Getting Started

1. Clone the repository or download the source code.
2. Open the project in Android Studio.
3. Build and run the project on an Android device or emulator.

## Usage

The `MainActivity.kt` file contains the main activity logic. It sets up the RecyclerView and populates it with video data. It also handles item click events.

The `VideoAdapter.kt` file contains the RecyclerView adapter responsible for binding data to the list items. It implements click handling for each item.

## Dependencies

This project uses the following dependencies:

- RecyclerView: For displaying the list of videos.
- Kotlin Standard Library: For Kotlin language support.

## Mock Data

The application uses mock data for demonstration purposes. Replace this data with actual data from your data source.
