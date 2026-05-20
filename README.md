# Rick and Morty Characters

Android application built with Kotlin and Jetpack Compose that consumes the Rick and Morty API to display a list of characters.

## Technical decisions

### Architecture
The project follows a layered architecture inspired by Clean Architecture:

- **Data layer**
    - Retrofit API service
    - DTO models
    - Repository implementation
    - DTO to Domain mappers

- **Domain layer**
    - Domain models
    - Repository contract
    - Use cases

- **Presentation layer**
    - ViewModel
    - Explicit UI state management (Loading / Success / Error)
    - Jetpack Compose UI

This separation was chosen to keep responsibilities isolated and improve maintainability, testability, and scalability.

---

### Dependency Injection
I used Hilt for dependency injection to:

- Decouple object creation
- Improve testability
- Centralize dependency configuration

---

### UI State Management
The UI is driven by a sealed state model:

- Loading
- Success
- Error

This makes state transitions explicit and predictable.

---

### Image Loading
Coil was used for image loading due to its native Compose integration.

The implementation uses explicit image state handling through `SubcomposeAsyncImage`, including:

- Placeholder while loading
- Error fallback rendering
- Memory, disk and network cache policies enabled

Given the limited dataset size and relatively small number of images per page, this approach provides clear state visibility without introducing noticeable performance overhead.

For larger-scale lists or more performance-sensitive scenarios, a simpler `AsyncImage` implementation would likely be preferable to reduce subcomposition cost.

---

### Networking
Retrofit was used for API communication due to its simplicity and strong Kotlin ecosystem integration.

---

## What was left out due to time constraints

The following improvements were intentionally left out to prioritize the required scope:

- API-driven pagination support using the metadata already exposed by the backend
- Pull-to-refresh
- Unit tests
- UI tests
- Navigation to character detail screen
- Externalizing strings and dimensions into Android resources
- Offline caching
- Typed error classification with localized user-friendly messaging
- Additional API feature support (locations / episodes)
- Additional UI polish and transitions

---

## What I would improve with more time

### Functional improvements

- Implement API-driven pagination using the metadata already exposed by the backend (`next`, `prev`, page count, total results)
- Add character detail navigation from the list screen
- Expand the app to support additional API domains such as locations and episodes
- Introduce pull-to-refresh support

### UI / Android platform improvements

- Externalize strings and dimensions into Android resources
- Improve visual polish and animations
- Add dark theme refinements

### Architecture improvements

- Introduce typed error classification to provide more specific localized user feedback while keeping presentation logic framework-agnostic.
- Add local caching for offline support
- Add navigation modularization for feature scalability

### Testing
- Unit tests for:
    - Use cases
    - Repository
    - ViewModel

- UI tests for:
    - Loading state
    - Error state
    - Retry flow

---

## AI usage

- AI-assisted tooling was used selectively as part of the development workflow for technical exploration, validation of implementation alternatives, and acceleration of configuration troubleshooting.

- Its usage was limited to iterative problem-solving support and architectural discussion. Final implementation decisions, technical trade-off evaluation, integration, debugging, and code validation were performed manually.

All final technical decisions, implementation choices, debugging, and code integration were reviewed and validated manually during development.