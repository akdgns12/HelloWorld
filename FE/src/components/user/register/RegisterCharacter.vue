<script>
import { Splide, SplideSlide } from '@splidejs/vue-splide';
// Default theme
import '@splidejs/vue-splide/css';
export default {
    name: 'RegisterCharacter',
    component:
    {
        Splide,
        SplideSlide,
    }
    ,
    data() {
        return {
            options: {
                type: 'loop',
                rewind: true,
                perPage: 1,
                autoplay: false,
                pauseOnHover: false,
                arrows: true,
                dots: false,
                animatedDots: false,
                speed: 800,
                fixedWidth: '100%',
                padding: 10,
                pagination: false,
            },
        };
    },
}
</script>

<template>
    <div class="logos">
        <div class="logo">
            <router-link to="/"><img class="logo-img" src="../../../assets/image/Logo.png" alt="logo" /></router-link>
        </div>
        <div class="person">
            <router-link to="/"><img class="person-img" src="../../../assets/image/Person.png" alt="logo" /></router-link>
        </div>
    </div>
    <div class="my-character-container">
        <img class="my-character-img" src="../../../assets/image/MyAvatar.png" alt="내 아바타" />
    </div>
    <div class="wrap">
        <div class="hair-container">
            <div class="hair">헤어</div>
            <div class="select-hair">
                <splide :options="options" class="slider">
                    <splide-slide class="splide-slide">
                        <div class="one-slide">
                            <div class="hair-element-container"><img class="hair-element"
                                    src="../../../assets/image/Person.png" alt="헤어" /></div>
                            <div class="hair-element-container"><img class="hair-element"
                                    src="../../../assets/image/Person.png" alt="헤어" /></div>
                            <div class="hair-element-container"><img class="hair-element"
                                    src="../../../assets/image/Person.png" alt="헤어" /></div>
                            <div class="hair-element-container"><img class="hair-element"
                                    src="../../../assets/image/Person.png" alt="헤어" /></div>
                        </div>
                    </splide-slide>
                    <splide-slide class="splide-slide">
                        <div class="one-slide">
                            <div class="hair-element-container"><img class="hair-element"
                                    src="../../../assets/image/Person.png" alt="헤어" /></div>
                            <div class="hair-element-container"><img class="hair-element"
                                    src="../../../assets/image/Person.png" alt="헤어" /></div>
                            <div class="hair-element-container"><img class="hair-element"
                                    src="../../../assets/image/Person.png" alt="헤어" /></div>
                            <div class="hair-element-container"><img class="hair-element"
                                    src="../../../assets/image/Person.png" alt="헤어" /></div>
                        </div>
                    </splide-slide>
                    <splide-slide class="splide-slide">
                        <div class="one-slide">
                            <div class="hair-element-container"><img class="hair-element"
                                    src="../../../assets/image/Person.png" alt="헤어" /></div>
                            <div class="hair-element-container"><img class="hair-element"
                                    src="../../../assets/image/Person.png" alt="헤어" /></div>
                            <div class="hair-element-container"><img class="hair-element"
                                    src="../../../assets/image/Person.png" alt="헤어" /></div>
                            <div class="hair-element-container"><img class="hair-element"
                                    src="../../../assets/image/Person.png" alt="헤어" /></div>
                        </div>
                    </splide-slide>
                </splide>
            </div>
        </div>
        <div class="tone-container">
            <div class="tone">피부색</div>
            <div class="select-tone">
                <splide :options="options" class="slider">
                    <splide-slide class="splide-slide">
                        <div class="one-slide">
                            <div class="hair-element-container"><img class="hair-element"
                                    src="../../../assets/image/Person.png" alt="피부색" /></div>
                            <div class="hair-element-container"><img class="hair-element"
                                    src="../../../assets/image/Person.png" alt="피부색" /></div>
                            <div class="hair-element-container"><img class="hair-element"
                                    src="../../../assets/image/Person.png" alt="피부색" /></div>
                            <div class="hair-element-container"><img class="hair-element"
                                    src="../../../assets/image/Person.png" alt="피부색" /></div>
                        </div>
                    </splide-slide>
                    <splide-slide class="splide-slide">
                        <div class="one-slide">
                            <div class="hair-element-container"><img class="hair-element"
                                    src="../../../assets/image/Person.png" alt="피부색" /></div>
                            <div class="hair-element-container"><img class="hair-element"
                                    src="../../../assets/image/Person.png" alt="피부색" /></div>
                            <div class="hair-element-container"><img class="hair-element"
                                    src="../../../assets/image/Person.png" alt="피부색" /></div>
                            <div class="hair-element-container"><img class="hair-element"
                                    src="../../../assets/image/Person.png" alt="피부색" /></div>
                        </div>
                    </splide-slide>
                    <splide-slide class="splide-slide">
                        <div class="one-slide">
                            <div class="hair-element-container"><img class="hair-element"
                                    src="../../../assets/image/Person.png" alt="피부색" /></div>
                            <div class="hair-element-container"><img class="hair-element"
                                    src="../../../assets/image/Person.png" alt="피부색" /></div>
                            <div class="hair-element-container"><img class="hair-element"
                                    src="../../../assets/image/Person.png" alt="피부색" /></div>
                            <div class="hair-element-container"><img class="hair-element"
                                    src="../../../assets/image/Person.png" alt="피부색" /></div>
                        </div>
                    </splide-slide>
                </splide>
            </div>
        </div>
        <div class="tone-container">
            <div class="tone">피부색</div>
            <div class="select-tone">
                <splide :options="options" class="slider">
                    <splide-slide class="splide-slide">
                        <div class="one-slide">
                            <div class="hair-element-container"><img class="hair-element"
                                    src="../../../assets/image/Person.png" alt="피부색" /></div>
                            <div class="hair-element-container"><img class="hair-element"
                                    src="../../../assets/image/Person.png" alt="피부색" /></div>
                            <div class="hair-element-container"><img class="hair-element"
                                    src="../../../assets/image/Person.png" alt="피부색" /></div>
                            <div class="hair-element-container"><img class="hair-element"
                                    src="../../../assets/image/Person.png" alt="피부색" /></div>
                        </div>
                    </splide-slide>
                    <splide-slide class="splide-slide">
                        <div class="one-slide">
                            <div class="hair-element-container"><img class="hair-element"
                                    src="../../../assets/image/Person.png" alt="피부색" /></div>
                            <div class="hair-element-container"><img class="hair-element"
                                    src="../../../assets/image/Person.png" alt="피부색" /></div>
                            <div class="hair-element-container"><img class="hair-element"
                                    src="../../../assets/image/Person.png" alt="피부색" /></div>
                            <div class="hair-element-container"><img class="hair-element"
                                    src="../../../assets/image/Person.png" alt="피부색" /></div>
                        </div>
                    </splide-slide>
                    <splide-slide class="splide-slide">
                        <div class="one-slide">
                            <div class="hair-element-container"><img class="hair-element"
                                    src="../../../assets/image/Person.png" alt="피부색" /></div>
                            <div class="hair-element-container"><img class="hair-element"
                                    src="../../../assets/image/Person.png" alt="피부색" /></div>
                            <div class="hair-element-container"><img class="hair-element"
                                    src="../../../assets/image/Person.png" alt="피부색" /></div>
                            <div class="hair-element-container"><img class="hair-element"
                                    src="../../../assets/image/Person.png" alt="피부색" /></div>
                        </div>
                    </splide-slide>
                </splide>
            </div>
        </div>
        <div class="tone-container">
            <div class="tone">피부색</div>
            <div class="select-tone">
                <splide :options="options" class="slider">
                    <splide-slide class="splide-slide">
                        <div class="one-slide">
                            <div class="hair-element-container"><img class="hair-element"
                                    src="../../../assets/image/Person.png" alt="피부색" /></div>
                            <div class="hair-element-container"><img class="hair-element"
                                    src="../../../assets/image/Person.png" alt="피부색" /></div>
                            <div class="hair-element-container"><img class="hair-element"
                                    src="../../../assets/image/Person.png" alt="피부색" /></div>
                            <div class="hair-element-container"><img class="hair-element"
                                    src="../../../assets/image/Person.png" alt="피부색" /></div>
                        </div>
                    </splide-slide>
                    <splide-slide class="splide-slide">
                        <div class="one-slide">
                            <div class="hair-element-container"><img class="hair-element"
                                    src="../../../assets/image/Person.png" alt="피부색" /></div>
                            <div class="hair-element-container"><img class="hair-element"
                                    src="../../../assets/image/Person.png" alt="피부색" /></div>
                            <div class="hair-element-container"><img class="hair-element"
                                    src="../../../assets/image/Person.png" alt="피부색" /></div>
                            <div class="hair-element-container"><img class="hair-element"
                                    src="../../../assets/image/Person.png" alt="피부색" /></div>
                        </div>
                    </splide-slide>
                    <splide-slide class="splide-slide">
                        <div class="one-slide">
                            <div class="hair-element-container"><img class="hair-element"
                                    src="../../../assets/image/Person.png" alt="피부색" /></div>
                            <div class="hair-element-container"><img class="hair-element"
                                    src="../../../assets/image/Person.png" alt="피부색" /></div>
                            <div class="hair-element-container"><img class="hair-element"
                                    src="../../../assets/image/Person.png" alt="피부색" /></div>
                            <div class="hair-element-container"><img class="hair-element"
                                    src="../../../assets/image/Person.png" alt="피부색" /></div>
                        </div>
                    </splide-slide>
                </splide>
            </div>
        </div>
        <div class="tone-container">
            <div class="tone">피부색</div>
            <div class="select-tone">
                <splide :options="options" class="slider">
                    <splide-slide class="splide-slide">
                        <div class="one-slide">
                            <div class="hair-element-container"><img class="hair-element"
                                    src="../../../assets/image/Person.png" alt="피부색" /></div>
                            <div class="hair-element-container"><img class="hair-element"
                                    src="../../../assets/image/Person.png" alt="피부색" /></div>
                            <div class="hair-element-container"><img class="hair-element"
                                    src="../../../assets/image/Person.png" alt="피부색" /></div>
                            <div class="hair-element-container"><img class="hair-element"
                                    src="../../../assets/image/Person.png" alt="피부색" /></div>
                        </div>
                    </splide-slide>
                    <splide-slide class="splide-slide">
                        <div class="one-slide">
                            <div class="hair-element-container"><img class="hair-element"
                                    src="../../../assets/image/Person.png" alt="피부색" /></div>
                            <div class="hair-element-container"><img class="hair-element"
                                    src="../../../assets/image/Person.png" alt="피부색" /></div>
                            <div class="hair-element-container"><img class="hair-element"
                                    src="../../../assets/image/Person.png" alt="피부색" /></div>
                            <div class="hair-element-container"><img class="hair-element"
                                    src="../../../assets/image/Person.png" alt="피부색" /></div>
                        </div>
                    </splide-slide>
                    <splide-slide class="splide-slide">
                        <div class="one-slide">
                            <div class="hair-element-container"><img class="hair-element"
                                    src="../../../assets/image/Person.png" alt="피부색" /></div>
                            <div class="hair-element-container"><img class="hair-element"
                                    src="../../../assets/image/Person.png" alt="피부색" /></div>
                            <div class="hair-element-container"><img class="hair-element"
                                    src="../../../assets/image/Person.png" alt="피부색" /></div>
                            <div class="hair-element-container"><img class="hair-element"
                                    src="../../../assets/image/Person.png" alt="피부색" /></div>
                        </div>
                    </splide-slide>
                </splide>
            </div>
        </div>
    </div>
    <div class="button-group">
            <button class="cancel-btn" @click="this.$router.push({path: '/join'})">이전</button>
            <button class="next-btn" @click="this.$router.push({path: '/'})">완료</button>
        </div>
</template>

<style scoped>
a {
    text-decoration: none;
    color: white;
}

.splide-slide {
    display: flex;
    height: 50px;
}

.one-slide {
    margin: 0 auto;
    display: flex;
    justify-content: space-evenly;
}

.hair-element-container {
    width: 80px;
    height: 50px;
    margin-right: 5%;
    margin-left: 5%;
    margin-bottom: 5%;
}

.hair-element {
    width: 100%;
    height: 100%;
    object-fit: fill;
}

.wrap {
    position: absolute;
    top: 5%;
    left: 40%;
    width: 60%;
    text-align: start;
}

.slider {
    width: 100%;
    margin: 0 auto;
}

.my-character-container {
    margin-left: 10%;
    margin-top: 15%;
    width: 25%;
    height: 25%;
    /* border: 1px solid #6A6A6A; */
    border-radius: 20px;
}

.my-character-img {
    width: 100%;
    height: 100%;
    object-fit: contain;
}

.logos {
    display: flex;
    position: absolute;
    top: 5%;
    left: 10%;
    width: 15%;

}

.logo {
    width: 80%;
    height: 140%;
}

.logo-img {
    width: 100%;
    height: 100%;
    object-fit: cover;
}

.person {
    width: 45%;
    height: 100%;
}

.person-img {
    width: 100%;
    height: 100%;
    object-fit: cover;
}

.hair-container {
    width: 90%;
    margin-bottom: 12px;
}

.hair {
    color: #82ACC1;
    font-size: 13px;
    font-weight: 600;
    margin-bottom: 5px;
}

.select-hair {
    width: 90%;
}

.tone-container {
    width: 90%;
    margin-bottom: 12px;
}

.tone {
    color: #82ACC1;
    font-size: 13px;
    font-weight: 600;
    margin-bottom: 5px;
}

.select-tone {
    width: 90%;
}

.button-group {
    display: flex;
    justify-content: space-between;
    margin: 0 auto;
    margin-top: 63px;
    width: 30%;
}

.cancel-btn {
    width: 49%;
    padding-top: 6px;
    padding-bottom: 6px;
    background-color: #D24646;
    opacity: 78%;
    border: none;
    border-radius: 4px;
    color: white;
    font-weight: 500;
    cursor: pointer;
    text-decoration: none;
}

.next-btn {
    width: 49%;
    padding-top: 6px;
    padding-bottom: 6px;
    background-color: #82ACC1;
    border: none;
    border-radius: 4px;
    color: white;
    font-weight: 500;
    cursor: pointer;
}
</style>