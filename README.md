Kitman Labs Demo App 🧠⚡️

This repository contains the source code for the Kitman Labs Demo App, showcasing modern Android development practices using Jetpack Compose and Clean Architecture.

🧩 Tech Stack

The app is built with:
	•	Jetpack Compose — declarative UI with Navigation
	•	MVVM Architecture — separation of concerns
	•	Clean Architecture — use case–driven structure
	•	Room Database — local data persistence
	•	Retrofit — API communication
	•	kotlinx.serialization — JSON serialization/deserialization
	•	Hilt — dependency injection
	•	Single-Activity Architecture
	•	Repository Pattern — clean data layer abstraction

⸻

🚀 Planned Enhancements

Functional
	•	Squad name chips in the athlete list screen to view athletes by their respective squads.
	•	“Add to favourites” feature to help coaches quickly access key athletes.

Technical
	•	Unit tests for ViewModels and UseCases, plus UI tests for Composables (with screenshot comparison against Figma during PR review).
	•	Event logging for user interactions and performance metrics to enhance analytics and engagement tracking.
	•	Proper database migration handling for Room.
	•	Pagination for server-side list data using Kotlin Flow.

UI
	•	Lottie animation for the Kitman Labs logo on the splash screen.
	•	Shimmer effects for loading states.
	•	Smooth “Hero” animations between list and detail screens.

AI (Future Research)
	•	Exploring on-device AI to analyze athlete data from multiple sources (e.g. wearables, video) for intelligent insights and performance metrics without compromising minor data loss with low latency in device local.
⸻

🎥 Demo Video

Due to GitHub’s 10 MB file limit, please refer to the YouTube demo for a complete walkthrough:

▶️ Demo Video on YouTube￼

⸻https://www.youtube.com/shorts/LBOnx1g-wjA

🧠 Summary

This project demonstrates:
	•	Modern Android app architecture using Compose + Hilt + MVVM + Clean Architecture
	•	Scalable structure for future AI integrations
	•	Attention to performance, UX, and code quality
