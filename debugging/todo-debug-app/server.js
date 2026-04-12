const http = require('http');

let todos = [];

const server = http.createServer((req, res) => {
  if (req.method === 'GET' && req.url === '/todos') {
    res.writeHead(200, { 'Content-Type': 'application/json' });
    res.end(JSON.stringify(todos));
  }

  else if (req.method === 'POST' && req.url === '/todos') {
    let body = '';

    req.on('data', chunk => {
      body += chunk.toString();
    });

    req.on('end', () => {
      const parsed = JSON.parse(body);

      const todo = {
        id: Date.now(),
        title: parsed.title
      };

      todos.push(todo);

      res.writeHead(201, { 'Content-Type': 'application/json' });
      res.end(JSON.stringify(todo));
    });
  }

  else {
    res.writeHead(404);
    res.end('Not Found');
  }
});

server.listen(3000, () => {
  console.log('Server running on http://localhost:3000');
});