# News Digest

A modern Android application that fetches the latest news articles, allows offline bookmarking, and periodically checks for new content in the background.

## Features

### Article Feed

* Fetches news articles from NewsAPI
* Displays article title, source, publication date, and thumbnail
* Supports pull-to-refresh

### Article Details

* View full article information
* Open article content
* Bookmark articles for later reading

### Bookmarks

* Save articles for offline access
* View all bookmarked articles
* Remove bookmarks

### Background Sync

* Periodically checks for new articles using WorkManager
* Sync runs only when network connectivity is available

### Notifications

* Detects newly available articles during background sync
* Sends notifications when new content is found

---

## Tech Stack

| Area                 | Technology                      |
| -------------------- | ------------------------------- |
| Language             | Kotlin                          |
| UI                   | Jetpack Compose                 |
| Architecture         | Clean Architecture + MVVM       |
| Dependency Injection | Hilt                            |
| Networking           | Retrofit                        |
| Local Storage        | Room                            |
| Async                | Coroutines + Flow               |
| Background Work      | WorkManager                     |

---

## Architecture

The project follows Clean Architecture with three layers:

### Presentation

* Compose Screens
* ViewModels
* UI State Management

### Domain

* Use Cases
* Repository Contracts
* Business Logic

### Data

* Remote API Integration
* Room Database
* Repository Implementations

Dependency direction:

```
Presentation
      ↓
    Domain
      ↑
     Data
```

---

## Build & Run

### Prerequisites

1. Obtain an API key from NewsAPI.org.
2. Add the API key to your local.properties file:

```properties
API_KEY=YOUR_API_KEY
```

### Run

```bash
./gradlew assembleDebug
```

or run the application directly from Android Studio.
---

## Background Sync & Notifications

The app periodically synchronizes articles in the background using WorkManager.

### Flow

1. `WorkManager` schedules a periodic sync task with a network connectivity constraint.
2. `FetchTopHeadlinesWorker` executes and triggers `SyncTopHeadlinesUseCase`.
3. The use case fetches the latest articles from the remote API through the repository.
4. Articles are stored in Room database.
5. Newly synced articles are marked with `isNotified = false`.
6. The worker queries articles that have not been notified yet.
7. If new articles are found:

   * A notification is displayed to the user.
   * Articles are marked as notified (`isNotified = true`) to prevent duplicate notifications.

### Notification Permission

On Android 13+ (API 33), the app requests the `POST_NOTIFICATIONS` runtime permission before displaying notifications.

### Improvements

Given more time, I would:

* Use article URL as the unique identifier instead of title.
* Track both `isSeen` and `isNotified` states separately.
* Add grouped notifications with article previews.
* Allow users to configure sync frequency from Settings.
* Add Room migrations for schema changes in production.


## Improvements

Given more time, I would:

* Add pagination for large article datasets
* Implement article search and filtering
* Improve notification grouping and deep linking
* Add better offline synchronization strategies
* Increase test coverage for edge cases and WorkManager flows
* Support multiple news sources and categories
