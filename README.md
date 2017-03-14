# MySimpleDataBinding
Simple example using android data binding with custom MVVM pattern and display using recycler view

## Synopsis
In this sample project, i use recyclerView to display data response from backend.
So i need to use 2 viewModel to update field (*MainActivityViewModel and EmailViewModel*).
  - **MainActivityViewModel** will handle UI model for MainActivity
  - **EmailViewModel** will handle UI changes on email item which is will be displayed on recycler.
In this project i use apiary for dummy response, and it will give simple response like below :
```
[
    "muhammad@email.com",
    "arif@email.com",
    "rohman@email.com",
    "hakim@email.com"
]
```
which will be stored as Observable with List of Strings as the type when retrieve data using *getEmails()* :
```
Observable<List<String>> getEmails();
```
For further details, you can check on the source code of current project.

  
## Library Used
  1. [Dagger 2](https://github.com/google/dagger)
  2. [Retrofit 2](https://github.com/square/retrofit)
  3. [OkHTTP](https://github.com/square/okhttp) 
  4. [OkHTTP Logging Interceptor](https://github.com/square/okhttp/tree/master/okhttp-logging-interceptor)
  5. [Rx Java](https://github.com/ReactiveX/RxJava)
  6. [Rx Android](https://github.com/ReactiveX/RxAndroid)
