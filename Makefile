# Makefile for ExplorerApp
# Compiles and runs the file explorer application

# Java compiler
JC = javac
# Java runtime
JVM = java
# Compiler flags
JFLAGS = -d bin -sourcepath src
# Source directory
SRCDIR = src
# Binary directory
BINDIR = bin
# Main class
MAIN_CLASS = com.esiea.pootd2.ExplorerApp

# Find all Java source files
SOURCES = $(shell find $(SRCDIR) -name "*.java")

# Marker file to track compilation
COMPILE_MARKER = $(BINDIR)/.compiled

# Default target
.PHONY: all
all: compile

# Create bin directory if it doesn't exist
$(BINDIR):
	mkdir -p $(BINDIR)

# Compile all Java files
.PHONY: compile
compile: $(COMPILE_MARKER)

$(COMPILE_MARKER): $(SOURCES) | $(BINDIR)
	@echo "Compiling Java sources..."
	$(JC) $(JFLAGS) $(SOURCES)
	@touch $(COMPILE_MARKER)
	@echo "Compilation complete!"

# Run with HTTP interface
.PHONY: http
http: $(COMPILE_MARKER)
	@echo "Starting application with HTTP interface..."
	$(JVM) -cp $(BINDIR) $(MAIN_CLASS) http

# Run with text interface
.PHONY: text
text: $(COMPILE_MARKER)
	@echo "Starting application with text interface..."
	$(JVM) -cp $(BINDIR) $(MAIN_CLASS) text

# Clean compiled files
.PHONY: clean
clean:
	@echo "Cleaning compiled files..."
	rm -rf $(BINDIR)
	@echo "Clean complete!"

# Rebuild everything
.PHONY: rebuild
rebuild: clean all

# Display help
.PHONY: help
help:
	@echo "ExplorerApp Makefile"
	@echo "===================="
	@echo ""
	@echo "Available targets:"
	@echo "  make compile  - Compile all Java sources"
	@echo "  make http     - Compile and run with HTTP interface (localhost:8001)"
	@echo "  make text     - Compile and run with text interface"
	@echo "  make clean    - Remove all compiled files"
	@echo "  make rebuild  - Clean and recompile"
	@echo "  make help     - Display this help message"
	@echo ""
	@echo "Examples:"
	@echo "  make http     # Start HTTP server on port 8001"
	@echo "  make text     # Start interactive text console"