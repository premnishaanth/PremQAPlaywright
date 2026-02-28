let frequency = "always";
let impact = "blocker";

if (frequency === "always" && impact === "blocker") {
    console.log("P0");
}
else if (frequency === "always" && impact === "major") {
    console.log("P1");
}
else if (frequency === "always" && impact === "minor") {
    console.log("P2");
}
else if (frequency === "often" && impact === "blocker") {
    console.log("P1");
}
else if (frequency === "often" && impact === "major") {
    console.log("P2");
}
else if (frequency === "often" && impact === "minor") {
    console.log("P3");
}
else if (frequency === "rarely" && impact === "blocker") {
    console.log("P2");
}
else if (frequency === "rarely" && impact === "major") {
    console.log("P3");
}
else if (frequency === "rarely" && impact === "minor") {
    console.log("P4");
}
else if (frequency === "sometimes" && impact === "blocker") {
    console.log("P3");
}
else if (frequency === "sometimes" && impact === "major") {
    console.log("P4");
}
else {
    console.log("Invalid Input");
}