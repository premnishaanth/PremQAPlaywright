function createUsers(names, roles) {
  return names.map((name, index) => {
    const username = name.toLowerCase().replace(/\s+/g, '_');
    const email = `${username}@playwrightbatch.com`;
    return {
      username,
      email,
      role: roles[index]
    };
  });
}

// Example usage
const names = ["Amit Kumar", "Neha Singh"];
const roles = ["admin", "viewer"];

console.log(createUsers(names, roles));

