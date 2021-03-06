package oob.daggertryout.MainComponent.Framework.DependencyInyection;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

@Scope
@Retention(RetentionPolicy.CLASS)
@interface MainActivityScopeInterface {
}
