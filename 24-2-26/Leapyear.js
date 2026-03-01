let year= "newyear";

if (year % 4 === 0  || year % 400 === 0){
    console.log(year + " Yes it is a Leap Year")
}
else if(year % 100 !== 0){
     console.log(year + " No it is not a Leap Year")
}
else{
    console.log("Enter a Valid Year")
}