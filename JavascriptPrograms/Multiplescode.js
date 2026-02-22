
for(let Value=1; Value<=100; Value++){
    if(Value%3 ==0){
        console.log("Fizz");
}
else if(Value%5 ==0){
    console.log("Buzz");
}
else if (Value%3==0 && Value%5==0)
{
    console.log("FizzBuzz");
}
else{
    console.log(Value);         
}
}