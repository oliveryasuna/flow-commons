/*
 * Copyright 2022 Oliver Yasuna
 *
 * Redistribution and use in source and binary forms, with or without modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the following disclaimer in the documentation
 *     and/or other materials provided with the distribution.
 * 3. Neither the name of the copyright holder nor the names of its contributors may be used to endorse or promote products derived from this software without
 *      specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR
 * TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package com.oliveryasuna.vaadin.commons.util;

import com.oliveryasuna.commons.language.condition.Arguments;
import com.oliveryasuna.commons.language.exception.UnsupportedInstantiationException;
import com.oliveryasuna.commons.language.marker.Utility;
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
@Utility
public final class VaadinUtils {

  // Static utility methods
  //--------------------------------------------------

  /**
   * Executes a Node.js command.
   *
   * @param command The command.
   *
   * @return The process.
   *
   * @throws IOException          See {@link ProcessBuilder#start()}.
   * @throws InterruptedException See {@link Process#waitFor()}.
   */
  public static Process executeNode(final String command) throws IOException, InterruptedException {
    final FrontendTools tools = new FrontendTools("", () -> FrontendUtils.getVaadinHomeDirectory().getAbsolutePath());
    final String node = tools.getNodeExecutable();

    final List<String> commands = new ArrayList<>();

    commands.add(node);
    if(command != null) commands.add(command);

    final ProcessBuilder builder = FrontendUtils.createProcessBuilder(commands);

    return builder.start();
  }

  /**
   * Executes a NPM command.
   *
   * @param command The command.
   *
   * @return The process.
   *
   * @throws IOException          See {@link ProcessBuilder#start()}.
   * @throws InterruptedException See {@link Process#waitFor()}.
   */
  public static Process executeNpm(final String command) throws IOException, InterruptedException {
    final FrontendTools tools = new FrontendTools("", () -> FrontendUtils.getVaadinHomeDirectory().getAbsolutePath());
    final List<String> node = tools.getNpmExecutable();

    final List<String> commands = new ArrayList<>(node);

    if(command != null) commands.add(command);

    final ProcessBuilder builder = FrontendUtils.createProcessBuilder(commands);

    return builder.start();
  }

  /**
   * Gets whether Vaadin is running in production mode.
   *
   * @param vaadinService The Vaadin service.
   *
   * @return {@code true}, if Vaadin is running in production mode; {@code false}, otherwise.
   */
  public static boolean isProductionMode(final VaadinService vaadinService) {
    Arguments.requireNotNull(vaadinService);

    return vaadinService.getDeploymentConfiguration().isProductionMode();
  }

  // Constructors
  //--------------------------------------------------

  private VaadinUtils() {
    super();

    throw new UnsupportedInstantiationException();
  }

}
