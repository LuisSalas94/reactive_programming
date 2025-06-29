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

---

# Fundamentals of Reactive Programming - Phase 1 · Module 3: The Reactive Streams Specification

![The Reactive Streams Specification](https://github.com/user-attachments/assets/7d9ed34b-a9fb-4eec-80fd-35aed0a4782e)

Reactive Streams is the standard for handling **asynchronous data streams with non-blocking backpressure**.  
It defines a minimal set of interfaces and rules that govern how data flows between publishers and subscribers.

These rules ensure systems are **robust**, **efficient**, and **predictable** — even under high load.


## 🔧 Key Takeaways

- Core interfaces: `Publisher`, `Subscriber`, `Subscription`, `Processor`
- How the signal lifecycle works: `onNext`, `onError`, `onComplete`
- The 4 key Reactive Streams rules (spec compliance)
- What can go wrong when the contract is violated


## 🛠️ When to Use

- You need to build or integrate with libraries that rely on reactive backpressure  
- You're implementing custom publishers/subscribers  
- You want full control and visibility into data flow behaviors


## 📂 See the Java Implementation  
👉 [View code on GitHub](https://github.com/LuisSalas94/reactive_programming/tree/main/src/main/java/org/fernando/phase1_fundamentals/module3_reactive_streams_spec)


## 📚 Learn More  
📄 **Medium Article** — [Fundamentals of Reactive Programming — Phase 1, Module 3: The Reactive Streams Specification](https://blog.stackademic.com/fundamentals-of-reactive-programming-phase-1-module-3-the-reactive-streams-specification-3743756b49e7)

🎥 **YouTube Video** — Coming soon

---

# Fundamentals of Reactive Programming - Phase 1 · Module 4: Core Reactive Concepts & Behavior

![Core Reactive Concepts   Behavior](https://github.com/user-attachments/assets/8a7c79b8-7b8b-4106-8aa7-2d21ab4e9358)


Reactive programming is more than just async data — it's about building systems that are **efficient**, **responsive**, and **resilient**.  
This module dives into three core behavioral concepts that define how reactive streams behave in real-world scenarios.

## 🔧 Key Takeaways

- **Lazy evaluation**: execution happens only when subscribed  
- **Cold vs Hot publishers**: replay vs live-only data sources  
- **Backpressure**: managing flow between producers and consumers

## 🛠️ When to Use

- You're debugging unexpected behavior in reactive chains  
- You need precise control over data emissions and subscriptions  
- You're building systems where consumer speed may vary

## 📂 See the Java Implementation  
👉 [View code on GitHub](https://github.com/LuisSalas94/reactive_programming/tree/main/src/main/java/org/fernando/phase1_fundamentals/module4_core_concepts)

## 📚 Learn More  
📄 **Medium Article** — [Fundamentals of Reactive Programming — Phase 1, Module 4: Core Reactive Concepts & Behavior](https://blog.stackademic.com/fundamentals-of-reactive-programming-phase-1-module-4-core-reactive-concepts-behavior-c6b0950b496d)

🎥 **YouTube Video** — Coming soon

---

# Fundamentals of Reactive Programming - Phase 1 · Module 5: Reactive Error Handling and Termination

![Reactive Error Handling and Termination](https://github.com/user-attachments/assets/71c8e93f-646f-4acf-acfb-641f33eb6b8b)


In reactive programming, **error handling is a first-class citizen**.  
Unlike imperative code, reactive streams treat errors as terminal signals (`onError`), and they must be handled without breaking the data flow.

This module explores how to manage errors in a **resilient** and **composable** way using Reactor's built-in strategies.

## 🔧 Key Takeaways

- Error as a signal: `onError` as part of the stream lifecycle  
- Design principles for non-blocking error handling  
- Fallback strategies: `onErrorResume`, `onErrorReturn`, `retry`  
- Side-effect hooks: `doOnError`, `doFinally`, `doOnTerminate`


## 🛠️ When to Use

- You need reliable error recovery in async pipelines  
- You're building fault-tolerant or user-facing reactive services  
- You want to add logging, metrics, or retries without side effects


## 📂 See the Java Implementation  
👉 [View code on GitHub](https://github.com/LuisSalas94/reactive_programming/tree/main/src/main/java/org/fernando/phase1_fundamentals/module5_error_handling)


## 📚 Learn More  
📄 **Medium Article** — [Fundamentals of Reactive Programming — Phase 1, Module 5: Reactive Error Handling and Termination](https://blog.stackademic.com/fundamentals-of-reactive-programming-phase-1-module-5-reactive-error-handling-and-termination-3fff2ab23f76)  

🎥 **YouTube Video** — Coming soon

---

# Fundamentals of Reactive Programming - Phase 1 · Module 6: Data Pipelines and Functional Composition

![Data Pipelines and Functional Composition](https://github.com/user-attachments/assets/ed4bc6b6-8145-4a4e-b4c1-dadcc18fa426)


Reactive programming shines when building **clean, declarative data pipelines** for asynchronous streams.  
In this module, you'll learn how to use functional operators to write expressive, readable, and safe reactive code.

We'll explore the building blocks of transformation and composition — and why **immutability** and **no side effects** are key to reliable stream behavior.

## 🔧 Key Takeaways

- Core operators: `map`, `filter`, `reduce`, `flatMap`  
- Chaining transformations in a readable pipeline  
- Importance of immutability and stateless operations  
- Why side effects (e.g., logging, DB calls) should stay out of pipelines

## 🛠️ When to Use

- You're transforming or filtering async data  
- You want to write clean, testable, and declarative reactive code  
- You’re building complex flows that must remain predictable

## 📂 See the Java Implementation  
👉 [View code on GitHub](https://github.com/LuisSalas94/reactive_programming/tree/main/src/main/java/org/fernando/phase1_fundamentals/module6_data_pipelines)

## 📚 Learn More  
📄 **Medium Article** — [Fundamentals of Reactive Programming — Phase 1, Module 6: Data Pipelines and Functional Composition](https://medium.com/@luisfernandosalasg/fundamentals-of-reactive-programming-phase-1-module-6-data-pipelines-and-functional-composition-5d7ef4fee8ad) 
 
🎥 **YouTube Video** — Coming soon

---

# Core Project Reactor: Mono and Flux - Phase 2 · Module 1: Understanding Mono and Flux

![Understanding Mono and Flux](https://github.com/user-attachments/assets/e705d46a-9140-4cf1-bee2-661b0318a25c)


In Project Reactor, everything starts with **`Mono` and `Flux`** — the two core types for representing asynchronous data.

- `Mono`: 0 or 1 item  
- `Flux`: 0 to N items  

This module introduces how these types work, when to use them, and why they’re essential for building **robust**, **non-blocking**, and **composable** reactive pipelines.

## 🔧 Key Takeaways

- What are `Mono` and `Flux`, and how do they differ?  
- Choosing the right type for your use case  
- Creating, subscribing to, and transforming streams  
- Common pitfalls and anti-patterns when using them

## 🛠️ When to Use

- You're modeling single vs multiple asynchronous values  
- You need to wrap external calls (HTTP, DB, etc.) reactively  
- You’re building services that return live or finite data streams

## 📂 See the Java Implementation  
👉 [View code on GitHub](https://github.com/LuisSalas94/reactive_programming/tree/main/src/main/java/org/fernando/phase2_core_reactor/module1_mono_flux)


## 📚 Learn More  
📄 **Medium Article** — [Core Project Reactor: Mono and Flux — Phase 2, Module 1: Understanding Mono and Flux](https://medium.com/@luisfernandosalasg/core-project-reactor-mono-and-flux-phase-2-module-1-understanding-mono-and-flux-20c1ecd0d33b)
  
🎥 **YouTube Video** — Coming soon

---

# Core Project Reactor: Mono and Flux - Phase 2 · Module 2: Operators Overview

![Operators Overview](https://github.com/user-attachments/assets/40daabb7-08a2-4b02-ad46-14fc5e011f8c)


Operators are the core tools for **building and shaping reactive pipelines**.  
Once you understand `Mono` and `Flux`, the next step is learning how to **transform**, **combine**, and **react** to data using Reactor's rich operator set.

With operators, you can compose logic **declaratively and non-blockingly**, maintaining full control over your stream's behavior.

## 🔧 Key Takeaways

- Categories of operators: transformation, filtering, combination, lifecycle  
- How operators modify data flow and signal handling  
- Chaining operators to build readable, functional pipelines  
- Best practices for using side-effect and terminal operators

## 🛠️ When to Use

- You're processing, transforming, or merging async data  
- You want to write fluent, expressive pipelines  
- You're handling stream completion, errors, or retries reactively

## 📂 See the Java Implementation  
👉 [View code on GitHub](https://github.com/LuisSalas94/reactive_programming/tree/main/src/main/java/org/fernando/phase2_core_reactor/module2_operators_overview)

## 📚 Learn More  
📄 **Medium Article** — [Core Project Reactor: Mono and Flux — Phase 2, Module 2: Operators Overview](https://medium.com/@luisfernandosalasg/core-project-reactor-mono-and-flux-phase-2-module-2-operators-overview-336cfd315882)
 
🎥 **YouTube Video** — Coming soon

---

# Core Project Reactor: Mono and Flux - Phase 2 · Module 3: Handling Sequence Transformations

![Handling Sequence Transformations](https://github.com/user-attachments/assets/0c3af486-ee92-47ed-b3f7-fb2dc2b44278)


Building responsive and predictable reactive systems means mastering **sequence transformation operators** — especially `flatMap`, `concatMap`, and `zip`.

These operators let you control how data is **processed**, **merged**, and **ordered** across asynchronous streams — with big impacts on concurrency and output behavior.

This module uses simulated book data to explore real-world scenarios and trade-offs.

## 🔧 Key Takeaways

- Differences between `flatMap`, `concatMap`, and `zip`  
- How transformations impact concurrency and ordering  
- Choosing the right operator based on use case  
- Safely combining multiple streams in reactive flows

## 🛠️ When to Use

- You’re merging multiple async sources or nested streams  
- You need control over execution order or parallelism  
- You’re building complex, multi-step pipelines

## 📂 See the Java Implementation  
👉 [View code on GitHub](https://github.com/LuisSalas94/reactive_programming/tree/main/src/main/java/org/fernando/phase2_core_reactor/module3_sequence_transformations)

## 📚 Learn More  
📄 **Medium Article** — [Core Project Reactor: Mono and Flux — Phase 2, Module 3: Handling Sequence Transformations](https://medium.com/@luisfernandosalasg/core-project-reactor-mono-and-flux-phase-2-module-3-handling-sequence-transformations-80c937e400cb)
  
🎥 **YouTube Video** — Coming soon

---

# Core Project Reactor: Mono and Flux - Phase 2 · Module 4: Creating Dynamic Data Streams

![Creating Dynamic Data Streams](https://github.com/user-attachments/assets/cb58df30-174b-4a2a-9312-b4d382bc6854)

Real-world reactive apps deal with **dynamic, unpredictable data** — from user input and events to paginated APIs and sensor feeds.  
In these cases, `Flux.just()` or `Flux.fromIterable()` won’t cut it.

This module introduces two powerful operators for generating data programmatically:  
**`Flux.generate()`** and **`Flux.create()`** — giving you full control over **how**, **when**, and **what** gets emitted.

## 🔧 Key Takeaways

- Differences between `generate()` (sync, one-by-one) and `create()` (async, multi-item)  
- Emitting dynamic or on-demand data into a reactive stream  
- Managing state, callbacks, and backpressure manually  
- Practical use cases: live input, paginated responses, event emitters

## 🛠️ When to Use

- You need to push data into a stream programmatically  
- You're modeling live, event-driven, or request-driven sources  
- You want fine-grained control over stream behavior


## 📂 See the Java Implementation  
👉 [View code on GitHub](https://github.com/LuisSalas94/reactive_programming/tree/main/src/main/java/org/fernando/phase2_core_reactor/module4_dynamic_streams)


## 📚 Learn More  
📄 **Medium Article** — [Core Project Reactor: Mono and Flux — Phase 2, Module 4: Creating Dynamic Data Streams](https://medium.com/@luisfernandosalasg/core-project-reactor-mono-and-flux-phase-2-module-4-creating-dynamic-data-streams-7954f34a6fca)
  
🎥 **YouTube Video** — Coming soon

---

# Core Project Reactor: Mono and Flux - Phase 2 · Module 5: Testing Reactive Pipelines with StepVerifier

![Testing Reactive Pipelines with StepVerifier](https://github.com/user-attachments/assets/d05ec324-9b37-4e34-9abf-96bf378c78ad)


Reactive streams are powerful — but testing them can be tricky.  
Traditional testing tools don’t easily capture **emission timing**, **ordering**, or **error signals** in async pipelines.

This module introduces **StepVerifier**, part of Reactor’s test toolkit. It offers a **declarative, fluent API** to test `Mono` and `Flux` streams with precision — making it easy to assert exactly what happens, and when.

## 🔧 Key Takeaways

- Why traditional tests fall short for reactive flows  
- Introduction to `StepVerifier` and its fluent testing syntax  
- Validating emissions, completion, errors, and timing  
- Writing safe, readable, and robust reactive tests

## 🛠️ When to Use

- You’re testing complex or multi-step reactive sequences  
- You need to assert signal order, timing, or errors  
- You're building reactive libraries, services, or pipelines

## 📂 See the Java Implementation  
👉 [View code on GitHub](https://github.com/LuisSalas94/reactive_programming/tree/main/src/main/java/org/fernando/phase2_core_reactor/module5_stepverifier)

## 📚 Learn More  
📄 **Medium Article** — [Core Project Reactor: Mono and Flux — Phase 2, Module 5: Testing Reactive Pipelines with StepVerifier](https://medium.com/@luisfernandosalasg/core-project-reactor-mono-and-flux-phase-2-module-5-testing-reactive-pipelines-with-25d33c72b097)
  
🎥 **YouTube Video** — Coming soon

