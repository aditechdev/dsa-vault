# ⚡ DSA Vault — Java Data Structures & Algorithms

A practical learning repository for **Java, Data Structures and Algorithms (DSA), and technical interview preparation**. Use this repository to keep concept notes, Java implementations, solved problems, mistakes, and revision history in one place.

> **Learning loop:** Learn → Dry run → Implement → Analyze complexity → Test edge cases → Document → Revise

## Start Here

1. **[Complete course map](docs/README.md)** — the full learning tree and recommended sequence.
2. **[Java Foundations](docs/00-java-foundations/01-variables-and-data-types.md)** — our current guided lesson notes.
3. **[Learning progress](progress/learning-progress.md)** — what has been covered and what remains.
4. **[Problem tracker](progress/problem-tracker.md)** — record practice attempts and revision dates.
5. **[Mistake log](progress/mistake-log.md)** — capture misconceptions and lessons learned.

## Repository Structure

```text
dsa-vault/
├── README.md
├── docs/                         # Learning notes and course roadmap
│   ├── README.md                 # Complete DSA course map
│   ├── NOTE-TEMPLATE.md          # Standard note format
│   └── 00-java-foundations/      # Beginner Java notes
├── src/                          # Existing Java implementations (preserved)
│   ├── basic/
│   └── intermediate/
└── progress/                     # Learning, problems, and mistakes
    ├── learning-progress.md
    ├── problem-tracker.md
    └── mistake-log.md
```

The `docs/` roadmap is the **planned curriculum**. Topic files will be added as each subject is studied; a roadmap entry does not mean that topic is already documented or complete. Existing files under `src/` are retained rather than moved, so current IDE/package paths are not disrupted.

## Recommended Study Method

For each concept:

1. Explain the idea in your own words.
2. Dry-run a small example before coding.
3. Start with a correct brute-force approach.
4. Improve it when the constraints justify optimization.
5. Write Java code independently.
6. Analyze time and auxiliary-space complexity.
7. Test boundary cases and record mistakes.
8. Revisit the concept after a few days.

## Build and Run

### Prerequisites

- A Java Development Kit (JDK) installed.
- Terminal opened at the repository root.

### Compile Java sources

```bash
mkdir -p out
javac -d out $(find src -name "*.java")
```

If compilation fails, inspect the compiler's first error. Existing practice repositories can contain independent examples with different assumptions; fix the underlying package, class-name, or source-level issue rather than hiding compiler errors.

### Run a class

Use the fully qualified class name that matches its `package` declaration. For example, if the file declares `package intermediate.problems;`:

```bash
java -cp out intermediate.problems.SquareRoot
```

You can also run a class containing `main` directly from IntelliJ IDEA.

## Completion Standard

Mark a topic complete only when you can explain it, perform a dry run, implement the core logic without copying, identify important edge cases, and analyze complexity when applicable. Reading a solution alone is not completion.

## Interview Preparation Target

Prioritize understanding and recall over raw problem count. A useful long-term planning target is **200–300 carefully selected, well-understood problems**, with spaced revision and timed practice. Adjust the target to the interview requirements and gaps found in mock interviews.

## Maintainer

Maintained by [@aditechdev](https://github.com/aditechdev).

---

**Principle:** Consistent understanding beats memorizing large numbers of solutions.
