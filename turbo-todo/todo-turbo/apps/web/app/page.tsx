import { Todo } from "@repo/types";

export default async function Home() {
  const res = await fetch("http://localhost:3002/todos");
  const todos: Todo[] = await res.json();

  return (
    <div>
      {todos.map((t) => (
        <div key={t.id}>{t.text}</div>
      ))}
    </div>
  );
}
