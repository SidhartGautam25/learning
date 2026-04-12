const http = require("http");

let todos = [];

const server = http.createServer((req, res) => {
  console.log("\n📥 Incoming Request");
  console.log("Method:", req.method);
  console.log("URL:", req.url);

  if (req.method === "GET" && req.url === "/todos") {
    console.log("📤 Sending todos");

    res.writeHead(200, { "Content-Type": "application/json" });
    res.end(JSON.stringify(todos));
  } else if (req.method === "POST" && req.url === "/todos") {
    let body = "";

    req.on("data", (chunk) => {
      console.log("📦 Receiving chunk:", chunk.toString());
      body += chunk.toString();
    });

    req.on("end", () => {
      console.log("📦 Full body:", body);

      let parsed;

      try {
        parsed = JSON.parse(body);
      } catch (err) {
        console.error("❌ JSON Parse Error:", err.message);

        res.writeHead(400, { "Content-Type": "application/json" });
        return res.end(
          JSON.stringify({
            error: "Invalid JSON",
          }),
        );
      }

      if (!parsed.title) {
        console.error("❌ Missing title");

        res.writeHead(400, { "Content-Type": "application/json" });
        return res.end(
          JSON.stringify({
            error: "Title is required",
          }),
        );
      }

      const todo = {
        id: Date.now(),
        title: parsed.title,
      };

      todos.push(todo);

      console.log("✅ Todo created:", todo);

      res.writeHead(201, { "Content-Type": "application/json" });
      res.end(JSON.stringify(todo));
    });
  } else {
    console.log("❌ Route not found");

    res.writeHead(404);
    res.end("Not Found");
  }
});

server.listen(3000, () => {
  console.log("🚀 Server running on http://localhost:3000");
});
