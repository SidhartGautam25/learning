function outer() {
  let counter = 0;

  function inner() {
    counter++;
    console.log("Counter:", counter);
  }

  return inner;
}

const fn = outer();

debugger;

fn();
fn();
