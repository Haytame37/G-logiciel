// To-Do List Application - JavaScript
// Gestion complète des tâches avec localStorage

class ToDoApp {
  constructor() {
    this.tasks = [];
    this.currentFilter = "all";
    this.init();
  }

  init() {
    this.loadTasks();
    this.setupEventListeners();
    this.render();
  }

  setupEventListeners() {
    const addBtn = document.getElementById("addTaskBtn");
    const input = document.getElementById("taskInput");
    const clearBtn = document.getElementById("clearCompletedBtn");
    const filterBtns = document.querySelectorAll(".filter-btn");

    addBtn.addEventListener("click", () => this.addTask());
    input.addEventListener("keypress", (e) => {
      if (e.key === "Enter") this.addTask();
    });
    clearBtn.addEventListener("click", () => this.clearCompleted());
    filterBtns.forEach((btn) => {
      btn.addEventListener("click", (e) =>
        this.setFilter(e.target.dataset.filter),
      );
    });
  }

  addTask() {
    const input = document.getElementById("taskInput");
    const text = input.value.trim();

    if (text === "") {
      alert("Veuillez entrer une tâche");
      return;
    }

    const task = {
      id: Date.now(),
      text: text,
      completed: false,
      createdAt: new Date().toLocaleString("fr-FR"),
    };

    this.tasks.push(task);
    input.value = "";
    this.saveTasks();
    this.render();
  }

  deleteTask(id) {
    this.tasks = this.tasks.filter((task) => task.id !== id);
    this.saveTasks();
    this.render();
  }

  toggleTask(id) {
    const task = this.tasks.find((t) => t.id === id);
    if (task) {
      task.completed = !task.completed;
      this.saveTasks();
      this.render();
    }
  }

  clearCompleted() {
    const completed = this.tasks.filter((t) => t.completed).length;
    if (completed === 0) {
      alert("Aucune tâche terminée à effacer");
      return;
    }

    if (
      confirm(
        `Êtes-vous sûr de vouloir effacer ${completed} tâche(s) terminée(s) ?`,
      )
    ) {
      this.tasks = this.tasks.filter((t) => !t.completed);
      this.saveTasks();
      this.render();
    }
  }

  setFilter(filter) {
    this.currentFilter = filter;
    document.querySelectorAll(".filter-btn").forEach((btn) => {
      btn.classList.toggle("active", btn.dataset.filter === filter);
    });
    this.render();
  }

  getFilteredTasks() {
    switch (this.currentFilter) {
      case "completed":
        return this.tasks.filter((t) => t.completed);
      case "active":
        return this.tasks.filter((t) => !t.completed);
      default:
        return this.tasks;
    }
  }

  updateStats() {
    const total = this.tasks.length;
    const completed = this.tasks.filter((t) => t.completed).length;
    const active = total - completed;

    document.getElementById("totalCount").textContent = total;
    document.getElementById("completedCount").textContent = completed;
    document.getElementById("activeCount").textContent = active;

    // Désactiver le bouton si aucune tâche terminée
    document.getElementById("clearCompletedBtn").disabled = completed === 0;
  }

  render() {
    const taskList = document.getElementById("taskList");
    const emptyState = document.getElementById("emptyState");
    const filtered = this.getFilteredTasks();

    taskList.innerHTML = "";

    if (filtered.length === 0) {
      emptyState.classList.add("show");
    } else {
      emptyState.classList.remove("show");
      filtered.forEach((task) => {
        const li = document.createElement("li");
        li.className = `task-item ${task.completed ? "completed" : ""}`;
        li.innerHTML = `
                    <input type="checkbox" class="task-checkbox" ${task.completed ? "checked" : ""} 
                        onchange="app.toggleTask(${task.id})">
                    <span class="task-text">${this.escapeHtml(task.text)}</span>
                    <div class="task-actions">
                        <button class="btn-delete" onclick="app.deleteTask(${task.id})">Supprimer</button>
                    </div>
                `;
        taskList.appendChild(li);
      });
    }

    this.updateStats();
  }

  saveTasks() {
    localStorage.setItem("tasks", JSON.stringify(this.tasks));
  }

  loadTasks() {
    const saved = localStorage.getItem("tasks");
    this.tasks = saved ? JSON.parse(saved) : [];
  }

  escapeHtml(text) {
    const div = document.createElement("div");
    div.textContent = text;
    return div.innerHTML;
  }
}

// Initialiser l'application au chargement
let app;
document.addEventListener("DOMContentLoaded", () => {
  app = new ToDoApp();
});
