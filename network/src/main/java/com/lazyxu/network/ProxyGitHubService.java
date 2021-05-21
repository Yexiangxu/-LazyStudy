//package com.lazyxu.network;
//
//import org.jetbrains.annotations.NotNull;
//import org.jetbrains.annotations.Nullable;
//
//import java.lang.reflect.InvocationHandler;
//import java.lang.reflect.Method;
//import java.util.List;
//
//import retrofit2.Call;
//import retrofit2.Platform;
//
//public class ProxyGitHubService implements GitHubService{
//    InvocationHandler invocationHandler;
//    private final Platform platform = Platform.get();
//    private final Object[] emptyArgs = new Object[0];
//    @Override
//    public @Nullable Object invoke(Object proxy, Method method, @Nullable Object[] args)//invoke里面又是动态代理的核心
//            throws Throwable {
//        // If the method is a method from Object then defer to normal invocation.
//        if (method.getDeclaringClass() == Object.class) {
//            return method.invoke(this, args);
//        }
//        args = args != null ? args : emptyArgs;
//        return platform.isDefaultMethod(method)
//                ? platform.invokeDefaultMethod(method, service, proxy, args)
//                : loadServiceMethod(method).invoke(args);
//    }
//
//
//    @NotNull
//    @Override
//    public Call<List<Repo>> listRepos(@Nullable String user) {
//        Method method=GitHubService.class.getDeclaredMethod("listRepos", String.class);
//        return invocationHandler.invoke(this,method,user);
//    }
//}
