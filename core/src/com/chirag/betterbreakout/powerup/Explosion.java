package com.chirag.betterbreakout.powerup;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.chirag.betterbreakout.DeleteableGameElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Explosion implements DeleteableGameElement {
    private static final int PARTICLE_NUM = 20;

    private ArrayList<Particle> mParticles;

    public Explosion(float x, float y) {
        mParticles = new ArrayList<Particle>();
        Random random = new Random();

        for(int i = 0;i < PARTICLE_NUM;i ++) {
            float xVel = random.nextFloat();
            float yVel = random.nextFloat();

            mParticles.add(new Particle(x, y, xVel, yVel, Particle.ParticleType.EXPLOSION));
        }
    }

    @Override
    public boolean isDead() {
        return mParticles.isEmpty();
    }

    public void update() {
        List<Particle> toDelParticle = new ArrayList<Particle>();
        for(Particle particle : mParticles) {
            particle.update();
            if(particle.isDead()) {
                toDelParticle.add(particle);
            }
        }
        mParticles.removeAll(toDelParticle);
    }

    public void draw(SpriteBatch batch) {
        for(Particle particle : mParticles) {
            particle.draw(batch);
        }
    }
}