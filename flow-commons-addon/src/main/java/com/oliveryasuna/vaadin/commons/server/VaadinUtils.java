package com.oliveryasuna.vaadin.commons.server;

import com.vaadin.flow.server.VaadinService;
import com.vaadin.flow.server.frontend.FrontendTools;
import com.vaadin.flow.server.frontend.FrontendUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Various Vaadin utilities.
 *
 * @author Oliver Yasuna
 */
public final class VaadinUtils {

  /**
   * Executes a Node.js command.
   *
   * @param command The command.
   * @return The process's exit code.
   * @throws IOException          See {@link ProcessBuilder#start()}.
   * @throws InterruptedException See {@link Process#waitFor()}.
   */
  public static int executeNode(final String command) throws IOException, InterruptedException {
    final FrontendTools tools = new FrontendTools("", () -> FrontendUtils.getVaadinHomeDirectory().getAbsolutePath());
    final String node = tools.getNodeExecutable();

    final List<String> commands = new ArrayList<>();

    commands.add(node);
    if(command != null) commands.add(command);

    final ProcessBuilder builder = FrontendUtils.createProcessBuilder(commands);

    return builder.start().waitFor();
  }

  /**
   * Executes a NPM command.
   *
   * @param command The command.
   * @return The process's exit code.
   * @throws IOException          See {@link ProcessBuilder#start()}.
   * @throws InterruptedException See {@link Process#waitFor()}.
   */
  public static int executeNpm(final String command) throws IOException, InterruptedException {
    final FrontendTools tools = new FrontendTools("", () -> FrontendUtils.getVaadinHomeDirectory().getAbsolutePath());
    final List<String> node = tools.getNpmExecutable();

    final List<String> commands = new ArrayList<>(node);

    if(command != null) commands.add(command);

    final ProcessBuilder builder = FrontendUtils.createProcessBuilder(commands);

    return builder.start().waitFor();
  }

  /**
   * Gets whether Vaadin is running in production mode.
   *
   * @param service The Vaadin service.
   * @return If Vaadin is running in production mode, then {@code true}, else {@code false}.
   */
  public static boolean isProductionMode(final VaadinService service) {
    if(service == null) throw new IllegalArgumentException("Argument [server] is null.");

    return service.getDeploymentConfiguration().isProductionMode();
  }

  private VaadinUtils() {
    throw new UnsupportedOperationException("Class cannot be instantiated.");
  }

}
