function log(msg) {
  console.log(`[LOG]: ${msg}`);
}

function asyncTask(name, delay, callback) {
  log(`Start asyncTask: ${name}`);

  setTimeout(() => {
    log(`Inside setTimeout: ${name}`);
    callback(name);
  }, delay);
}

function promiseTask(name, delay) {
  log(`Start promiseTask: ${name}`);

  return new Promise((resolve) => {
    setTimeout(() => {
      log(`Resolving promise: ${name}`);
      resolve(name);
    }, delay);
  });
}

async function main() {
  log("Main start");

  asyncTask("A", 1000, (result) => {
    log(`Callback result: ${result}`);
  });

  const p1 = promiseTask("B", 500);

  const result = await p1;
  log(`Awaited result: ${result}`);

  Promise.resolve("C").then((val) => {
    log(`Microtask resolved: ${val}`);
  });

  log("Main end");
}

main();
