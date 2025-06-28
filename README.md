# ⚡ Reactive Programming in Java

This repository is a complete, hands-on guide to **Reactive Programming in Java** using **Project Reactor**. It teaches the core concepts, patterns, and best practices for building responsive, scalable, and asynchronous applications. You’ll find detailed explanations, real-world code samples, and practical modules designed to help you think reactively.

I'm also preparing a full companion **Medium article** and an in-depth **YouTube walkthrough** on my channel [`<CodeWithFernando/>`](https://youtube.com/@CodeWithFernando), so you can **learn by reading or watching** — whichever suits your style.

![CodeWithFernando](https://github.com/user-attachments/assets/65723913-bf7f-4576-8c13-e78a38153ff2)


## 📘 What Is Reactive Programming?

Reactive Programming is a paradigm for writing non-blocking, asynchronous systems that can handle a high volume of data and events with minimal resource usage. It’s built around the idea of **data streams**, **event propagation**, and **backpressure-aware** execution.

## 🚀 Why Reactive Programming?

Reactive systems are essential for building modern applications that are:

- 🔄 **Responsive** – react quickly to user interactions and system events  
- 📶 **Resilient** – gracefully handle failures, retries, and timeouts  
- 📈 **Scalable** – serve large volumes of concurrent users with fewer threads  
- 🔍 **Observable** – offer better traceability and debugging through signal flow

Reactive programming allows you to build applications that are **predictable under load**, **composable**, and **testable by design**.

## 📂 What You'll Learn

Each module is crafted with real-world examples (like book stores and APIs), covering topics such as:

- Mono and Flux: Reactive data types and their lifecycles  
- Operators: Transforming, filtering, and combining data streams  
- Sequence transformations: `flatMap`, `concatMap`, `zip`, and more  
- Dynamic stream generation: `Flux.create()`, `Flux.generate()`  
- Error handling and fallbacks  
- Testing with `StepVerifier`  
- Common pitfalls and best practices

## 🧪 Technologies Used

- **Java 17+**  
- **Project Reactor (reactor-core, reactor-test)**  
- **Maven or Gradle**  
- **JUnit 5**

---

# Fundamentals of Reactive Programming - Phase 1 · Module 1: Introduction to Reactive Thinking 

![Introduction to Reactive Thinking](https://github.com/user-attachments/assets/d8da8391-d4e6-435d-9a1c-2b023e338ef0)


Reactive programming changes how we build modern apps — making them **non-blocking**, **asynchronous**, and **event-driven**. In this module, you’ll learn the basics of reactive thinking and how it compares to imperative and asynchronous styles, with a real-world example: processing book data using **Project Reactor**.

## 🔧 Key Takeaways

- What is reactive programming?
- How it differs from imperative and async code
- Intro to `Flux`, `Mono`, and the Reactive Streams spec
- Real-world pipeline: transforming book data

## 🛠️ When to Use

- High-concurrency, event-driven systems  
- I/O-bound or streaming data workloads  
- You want fewer threads, better scalability

## 📂 See the Java Implementation  
👉 [View code on GitHub](https://github.com/LuisSalas94/reactive_programming/tree/main/src/main/java/org/fernando/phase1_fundamentals/module1_intro)

## 📚 Learn More  
📄 **Medium Article** — [Fundamentals of Reactive Programming — Phase 1, Module 1: Introduction to Reactive Thinking](https://medium.com/stackademic/fundamentals-of-reactive-programming-phase-1-module-1-introduction-to-reactive-thinking-0c4846044524)  
🎥 **YouTube Video** — [Reactive Programming with Project Reactor – Introduction to Reactive Thinking](https://www.youtube.com/watch?v=hwGfvoCCmpI&list=PLm17Av_kNv7OqVVMMhi3AosXWGJ_eOprJ)

---

# Fundamentals of Reactive Programming - Phase 1 · Module 2: Push vs Pull — Data Flow Paradigms

![Push vs Pull — Data Flow Paradigms](https://github.com/user-attachments/assets/92b164a0-bd90-4a28-9a2e-705a6025eff9)


Understanding how data flows through a system is fundamental to mastering reactive programming.  
This module introduces the two core paradigms of data flow:

- **Pull-based**: Consumers request data when they are ready.  
- **Push-based**: Producers emit data whenever it becomes available.

You’ll explore how these models differ, and why **Reactive Streams** adopt a push-pull hybrid approach to support **backpressure**.


## 🔧 Key Takeaways

- What is pull-based vs push-based data flow
- Why push dominates in reactive systems
- Introduction to backpressure and demand signals
- Project Reactor’s role in managing flow control

## 🛠️ When to Use

- You need to handle unpredictable data rates from external systems  
- Your consumers must control how much data they receive  
- You're building systems with streaming or async event sources

## 📂 See the Java Implementation  
👉 [View code on GitHub](https://github.com/LuisSalas94/reactive_programming/tree/main/src/main/java/org/fernando/phase1_fundamentals/module2_pushpull)

## 📚 Learn More  
📄 **Medium Article** — [Fundamentals of Reactive Programming — Phase 1, Module 2: Push vs Pull — Data Flow Paradigms
](https://blog.stackademic.com/fundamentals-of-reactive-programming-phase-1-module-2-push-vs-pull-data-flow-paradigms-d2d1b02d33df)

🎥 **YouTube Video** — [Reactive Programming with Project Reactor – Push vs Pull — Data Flow Paradigms](https://www.youtube.com/watch?v=pGs3dFI9hBo&list=PLm17Av_kNv7OqVVMMhi3AosXWGJ_eOprJ&index=2)







