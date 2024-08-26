const express = require('express');
const app = express();
const port = 3000;

app.use(express.json());

app.get('/api/users', (req, res) => {
  res.json({ message: 'Hello, world!' });
});

app.post('/api/users', (req, res) => {
  const { message } = req.body;
  if (message) {
    res.status(201).json({ message });
  } else {
    res.status(400).json({ error: 'Message is required' });
  }
});

app.listen(port, () => {
  console.log(`API server running at http://localhost:${port}`);
});
