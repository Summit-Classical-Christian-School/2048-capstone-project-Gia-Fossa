# AP CSA Capstone - 2048

A starter project for the AP Computer Science A Unit 9 Capstone Project: 2048.

## Getting Started

See the [setup guide](https://github.com/EMaher/JavaPlayground/blob/main/code-org/unit9/project/setup-vscode-github.adoc) for instructions on installing Java, VSCode, and Git.

### Quick Start

1. Open this project in VSCode
2. Wait for Java extensions to activate
3. Open `src/main/java/Runner.java`
4. Click **Run** above the `main` method (or press F5)

### Building from Command Line

```bash
# Compile
mvn compile

# Run
mvn exec:java
```

## Project Structure

```
ap-csa-capstone-2048/
├── pom.xml                    # Maven build configuration
├── src/
│   └── main/
│       └── java/
│           └── Runner.java    # Your starting point
└── README.md
```

## What to Build

Refer to your project handout for the complete requirements. You will create:

- **Tile** (superclass) — represents a cell on the board
- **EmptyTile** — a cell with no number
- **NumberTile** — a cell with a power-of-two value (2, 4, 8, ... 2048)
- **Board** — the 6×6 grid that handles sliding and merging
- **GameManager** — tracks the game state, player, and move history

## Adding New Classes

1. Right-click the `src/main/java` folder in VSCode
2. Select **New File**
3. Name it `ClassName.java` (e.g., `Board.java`)
4. Write your class code

## Running Tests (Optional)

If you write JUnit tests, place them in `src/test/java/` and run:

```bash
mvn test
```
