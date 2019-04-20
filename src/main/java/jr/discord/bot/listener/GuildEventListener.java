package jr.discord.bot.listener;

import net.dv8tion.jda.core.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import net.dv8tion.jda.core.utils.JDALogger;
import org.slf4j.Logger;

import static jr.discord.bot.constant.Messages.PRIVATE_WELCOME_MESSAGE;

public class GuildEventListener extends ListenerAdapter {

    private static final Logger LOGGER = JDALogger.getLog(GuildEventListener.class);


    @Override
    public void onGuildMemberJoin(GuildMemberJoinEvent event) {
        LOGGER.info("User {} joined.", event.getMember().getUser().getId());
        event.getMember().getUser().openPrivateChannel().queue(channel -> {
            channel.sendMessage(PRIVATE_WELCOME_MESSAGE).queue();
        });
    }
}
