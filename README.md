# Java File Explorer

A command-line file explorer built in Java, with both text and web interfaces.


# Maintainers
- Romain Mechain - romain.mechain@et.esiea.fr
- Leni Chabilan - leni.chabilan@et.esiea.fr

## Quick Start

### Prerequisites
- Java JDK 17 or higher
- Make (optional, for using Makefile)

### Build and Run

**With Make:**
```bash
make compile # Compile the project

Run the desired interface:
make http    # Web interface on http://localhost:8001
make text    # Text interface in terminal
```

**Without Make:**
```bash
# Compile
javac -d bin -sourcepath src $(find src -name "*.java")

# Run
java -cp bin com.esiea.pootd2.ExplorerApp http  # Web interface
java -cp bin com.esiea.pootd2.ExplorerApp text  # Text interface
```

## Available Commands

- `ls` - List files and folders
- `cd <folder>` - Change directory
- `cd ..` - Go up one directory
- `mkdir <name>` - Create a folder
- `touch <name>` - Create a file
- `exit` - Quit the application


##  Usage

### Text Interface
```bash
> mkdir documents
> cd documents
> touch readme.txt
> ls
readme.txt 42567
```

### Web Interface
Launch the application with the `http` argument and access it via `http://localhost:8001`.

And that's it! You now have a simple Java file explorer with both text and web interfaces.

---


**ESIEA Project - December 2025**