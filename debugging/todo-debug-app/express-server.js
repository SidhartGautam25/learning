const express = require("express");

const app = express();
const PORT = 3000;

let todos = [];

// 🔥 Middleware 1 — Request logger
app.use((req, res, next) => {
  console.log("\n📥 Incoming Request");
  console.log("Method:", req.method);
  console.log("URL:", req.url);
  next();
});

// 🔥 Middleware 2 — JSON parser
app.use(express.json());

// 🔥 Middleware 3 — Debug body
app.use((req, res, next) => {
  console.log("📦 Parsed Body:", req.body);
  next();
});

// ✅ Route: GET
app.get("/todos", (req, res) => {
  console.log("📤 Sending todos");
  res.status(200).json(todos);
});

// ✅ Route: POST
app.post("/todos", (req, res) => {
  const { title } = req.body;

  if (!title) {
    console.error("❌ Missing title");
    return res.status(400).json({ error: "Title is required" });
  }

  const todo = {
    id: Date.now(),
    title,
  };

  todos.push(todo);

  console.log("✅ Todo created:", todo);

  res.status(201).json(todo);
});

// ❌ 404 handler
app.use((req, res) => {
  console.log("❌ Route not found");
  res.status(404).send("Not Found");
});

app.listen(PORT, () => {
  console.log(`🚀 Express server running on http://localhost:${PORT}`);
});
