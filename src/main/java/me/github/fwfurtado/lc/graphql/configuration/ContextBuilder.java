package me.github.fwfurtado.lc.graphql.configuration;

import graphql.kickstart.execution.context.GraphQLContext;
import graphql.kickstart.execution.context.GraphQLContextBuilder;
import graphql.kickstart.servlet.context.DefaultGraphQLServletContext;
import graphql.kickstart.servlet.context.DefaultGraphQLWebSocketContext;
import graphql.kickstart.servlet.context.GraphQLServletContextBuilder;
import lombok.AllArgsConstructor;
import org.dataloader.DataLoaderRegistry;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;
import javax.websocket.server.HandshakeRequest;

@Configuration
@AllArgsConstructor
public class ContextBuilder implements GraphQLServletContextBuilder {
    private final DataLoaderRegistry registry;

    @Override
    public GraphQLContext build(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        return DefaultGraphQLServletContext.createServletContext(registry, null)
                .with(httpServletRequest).with(httpServletResponse).build();
    }

    @Override
    public GraphQLContext build(Session session, HandshakeRequest handshakeRequest) {
        return DefaultGraphQLWebSocketContext.createWebSocketContext(registry, null)
                .with(session).with(handshakeRequest).build();
    }

    @Override
    public GraphQLContext build() {
        return DefaultGraphQLServletContext.createServletContext(registry, null).build();
    }
}
