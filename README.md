# Flow Commons.
 
A commons library for Vaadin Flow.

## Getting Started

**This documentation explores only a few features of this library.**

### Handle Beacon Requests

_This also demonstrates a use of classes found in `com.oliveryasuna.vaadin.commons.web.javascript.object`.
There are many useful classes to explore here._

You can add a listener for beacon requests.

```java
BeaconHandler.addBeaconListener(UI.getCurrent(), event -> System.out.println("Beacon for UI " + event.getSource().getUIId() + " with data \"" + event.getData() + "\"."));
```

The `BeaconHandler` instance will handle requests with the path `/beacon/<session_id>`,
where the `<session_id>` is acquired from the `UI` instance (`ui.getSession().getSession().getId()`).

The client can now send beacon requests. 

You can mock these requests from the server-side by telling the client to send them.
You have the `Navigator` class, which represents `navigator` (`window.navigator`) in JavaScript.

```java
Navigator.getInstance().sendBeacon(UI.getCurrent(), "/beacon/" + UI.getCurrent().getSession().getSession().getId(), "Hello, World!")
    .then(success -> System.out.println("Send a beacon request " + (Boolean.TRUE.equals(success) ? "successfully" : "unsuccessfully") + "."));
```

### Send Notifications to Active Users (Using `SessionUITracker`)

`CommonsServiceInitListener` registers `SessionUITracker` for session initialization and destruction.
`SessionUITracker` tracks (thread-safe) Vaadin sessions and their associated `UI` instances.

There are many uses for this, one being to send a notification to all active users.
For this, you have `UIUtils#forEachAccess(Consumer)`.

```java
UIUtils.forEachAccess(ui -> Notification.show("Hello there, favorite user!"))
``` 

There is also `UIUtils#forEach(Consumer)`, which unlike `UIUtils#forEachAccess(Consumer)`,
does not wrap the consumer in a call to `UI#access(Command)`.

### Local and Session Storage

You have the `Storage` class.
It's methods execute respective JavaScript code on the client.
You can access these methods with, for example, `Storage.getLocalStorageInstance()`, to execute the global `localStorage` alias,
or through `Window`, to execute as `window.localStorage`. For example:

```java
Window.getInstance().getLocalStorage().setItem(UI.getCurrent(), "key", "value")
    .thenRun(() -> {
      final UI ui = UI.getCurrent();
      
      ui.access(() -> Window.getInstance().getLocalStorage().getItem(ui, "key")
          .thenAccept(value -> System.out.println("key=" + value)));
    });
```

### Yummy Crunchy Cookies

Deal with cookies with ease.

There are more methods in `CookieUtils` then listed here.

Gets all cookie raw key/value pairs by getting the value of `document.cookie` and parsing it.

```java
System.out.println("Let's see what yummy cookies we have.");

CookieUtils.getAll(UI.getCurrent())
    .thenAccept(cookiesMap -> cookiesMap.entrySet().forEach((key, value) -> System.out.println(key + "=" + value)));
```

There is all `CookieUtils#get(UI, String)` for a single cookie value by key.

You can also set a cookie with `CookieUtils#set(UI, String, String)`.

### Easy Stream Resources

* `StreamResourceUtils#fromInputStream(String, InputStream)` – Create a `StreamResource` from an `InputStream`.
* `StreamResourceUtils#fromBytes(String, byte[])` – Create a `StreamResource` from an array of bytes. 
* `StreamResourceUtils#fromString(String, String, Charset)` – Create a `StreamResource` from a string.

## License

This code is under the [BSD 3-Clause](LICENSE.txt).

## Sponsoring

If you like my work and want to support it, please consider [sponsoring](https://github.com/sponsors/oliveryasuna) me. It's how I make the time to code great things!
