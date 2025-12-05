# Java File Explorer

A command-line file explorer built in Java, with both text and web interfaces.


# Maintainers
- Romain Mechain - romain.mechain@et.esiea.fr
- Leni Chabilan - leni.chabilan@et.esiea.fr

## Quick Start

### Prerequisites
- Java JDK 17 or higher

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
Launch the application with the `http`. Open a second terminal and use `curl`:
```bash
execute commands via HTTP:

# execute 'ls' command
curl -d "ls" -X POST http://localhost:8001/execute

# execute 'mkdir test' command
curl -d "mkdir test" -X POST http://localhost:8001/execute

# execute 'cd' command
curl -d "cd test" -X POST http://localhost:8001/execute

# execute 'touch' command
curl -d "touch file.txt" -X POST http://localhost:8001/execute

# execute 'cd' command
curl -d "cd .." -X POST http://localhost:8001/execute

# execute 'ls' command
curl -d "ls" -X POST http://localhost:8001/execute
```


---


**ESIEA Project - December 2025**