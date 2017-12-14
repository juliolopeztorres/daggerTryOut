DaggerTryOut
==============

A sample project to test Dependency Injection in Android Project (JAVA).

This project has a main Application and Activity. I create network dependencies in
Application level (Logging + Http Client with defined endpoints)
and inject those in Activity level.

I also use Scopes in order to maintain and split responsibilities between
Application and Activity (maybe improve this by specifying Application/Activity context). 

The UI is just a textView with default Hello World text that would be update 
by Http client model response with mocked data from Typicode. 

# Usage

Copy it, let Dagger 2 make its magic and build it with Android Studio. 

Enjoy!

[1]<a href="https://google.github.io/dagger/" target="_blank"> 
   Dagger 2 documentation from Google
   </a>
   <br/>

[2]<a href="https://www.youtube.com/watch?v=Qwk7ESmaCq0&list=PLuR1PJnGR-Ih-HXnGSpnqjdhdvqcwhfFU" target="_blank"> 
  TwistedEquations YT Video
  </a>
  <br/>
  
[3]<a href="https://jsonplaceholder.typicode.com/" target="_blank"> 
  JsonPlaceHolder Typicode
  </a>
  <br/>