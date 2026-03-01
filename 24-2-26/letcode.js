let side1 = 10, side2 = 20, side3 = 10

if (side1 === side2 && side2 === side3 && side1 === side3){
    console.log("Equilateral triangle");
}  else if(side1 === side2 || side2 === side3 || side1 === side3){
    console.log("Isosceles triangle");
} else
{
    console.log("scalene triangle");
}
