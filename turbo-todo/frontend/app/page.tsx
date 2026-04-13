type Todo = {
  id: number;
  text: string;
};

export default async function Home() {
  const res = await fetch("http://localhost:3001/todos");
  const todos = await res.json();

  return (
    <div>
      {todos.map((t: Todo) => (
        <div key={t.id}>{t.text}</div>
      ))}
    </div>
  );
}
