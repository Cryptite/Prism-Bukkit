package me.botsko.prism.commands;

import me.botsko.prism.Prism;
import me.botsko.prism.commandlibs.CallInfo;

import java.sql.Connection;
import java.util.List;

public class RecorderCommand extends AbstractCommand {

    /**
     *
     */
    private final Prism plugin;

    /**
     * Constructor.
     * @param plugin Prism
     */
    public RecorderCommand(Prism plugin) {
        this.plugin = plugin;
    }

    /**
     * Handle the command
     */
    @Override
    public void handle(final CallInfo call) {

        if (call.getArgs().length <= 1) {
            call.getSender().sendMessage(Prism.messenger.playerError("Invalid command. Use /pr ? for help"));
            return;
        }

        boolean recorderActive = checkRecorderActive(plugin);

        // Allow for canceling recorders
        if (call.getArg(1).equals("cancel")) {
            if (recorderActive) {
                plugin.recordingTask.cancel();
                plugin.recordingTask = null;
                call.getSender().sendMessage(Prism.messenger.playerMsg("Current recording task has been canceled."));
                call.getSender().sendMessage(Prism.messenger
                        .playerError("WARNING: Actions will collect until queue until recorder restarted manually."));
            } else {
                call.getSender().sendMessage(Prism.messenger.playerError("No recording task is currently running."));
            }
            return;
        }

        // Allow for force-restarting recorders
        if (call.getArg(1).equals("start")) {
            if (recorderActive) {
                call.getSender().sendMessage(
                        Prism.messenger.playerError("Recording tasks are currently running. Cannot start."));
            } else {

                // Run db tests...
                call.getSender().sendMessage(Prism.messenger.playerMsg("Validating database connections..."));

                // Attempt to get db
                Connection conn = null;
                try {

                    conn = Prism.getPrismDataSource().getConnection();
                    if (conn == null || conn.isClosed()) {
                        call.getSender().sendMessage(Prism.messenger.playerError(
                                "Valid database connection could not be found. Check the db/console and try again."));
                        return;
                    }

                    call.getSender().sendMessage(Prism.messenger.playerSuccess("Valid connection found. Yay!"));

                    call.getSender().sendMessage(Prism.messenger.playerMsg("Restarting recordering tasks..."));
                    plugin.actionRecorderTask();

                } catch (final Exception e) {
                    e.printStackTrace();
                } finally {
                    if (conn != null)
                        try {
                            conn.close();
                        } catch (final Exception ignored) {
                        }
                }
            }
        }
    }

    @Override
    public List<String> handleComplete(CallInfo call) {
        return null;
    }
}