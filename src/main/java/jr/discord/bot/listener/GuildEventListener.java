package jr.discord.bot.listener;

import static jr.discord.bot.constant.Messages.PRIVATE_WELCOME_MESSAGE;

import jr.discord.bot.command.CommandHandler;
import net.dv8tion.jda.core.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.core.events.message.priv.PrivateMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import net.dv8tion.jda.core.utils.JDALogger;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class GuildEventListener extends ListenerAdapter {

  private static final Logger LOGGER = JDALogger.getLog(GuildEventListener.class);
  private CommandHandler commandHandler;

  public GuildEventListener(CommandHandler commandHandler) {
    this.commandHandler = commandHandler;
  }

  @Override
  public void onGuildMemberJoin(GuildMemberJoinEvent event) {
    LOGGER.info("User {} joined.", event.getMember().getUser().getId());
    event.getMember().getUser().openPrivateChannel().queue(channel -> {
      channel.sendMessage(PRIVATE_WELCOME_MESSAGE).queue();
    });
  }

  @Override
  public void onPrivateMessageReceived(PrivateMessageReceivedEvent event) {
    if (commandHandler.isCommand(event.getMessage())) {
      commandHandler.process(event.getChannel(), event.getAuthor(), event.getMessage());
    }
  }

}
